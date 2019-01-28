package com.utilsClass;


import com.utils.Driver;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class ImportExeclF {
    static WebDriver driver;
    // 错误信息
    private String errorInfo;
    // 错误信息
    private static int readSheet = 0;
    private static boolean readSheetNum = false;

    private CallBackResult mCallBackResult = null;

    public void getExlContent(String excelPath) throws Exception {
        // readSheetNum = true 开启自定义读取sheet页 默认false(读取全部sheet页)
        readSheetNum = false;
        // readSheet默认为0(读取第一页) 值为2时读取第二页
        //当readSheetNum = false时  readSheet无作用
        readSheet = 1;
        ImportExeclF poi = new ImportExeclF();
        // 2003
//		 List<List<String>> list = poi.readExcel("D:\\excel\\EXCEL2003测试.xls");
        // 2007
        List<List<String>> list = poi.readExcel(excelPath);
        HashMap<String, String> map = new HashMap<String, String>();


        if (list != null && !list.isEmpty()) {
            //抽取list第一组数据作为表头放入String集合：
//            String[] fields = {"testno", "keyword", "result"};//用例字段属性值
            List<String> fields = list.get(0);
            int  size= fields.size();
            String[] array = new String[size];

            for (int i = 0; i <size ; i++) {
                array[i]=fields.get(i);
            }
            Driver.log.info("获取该表的各字段名：");
            for (String x:
                 array) {
                Driver.log.info(x+",");
            }
            System.out.println();


            for (int i = 1; i < list.size(); i++) {
                List<String> listCell = list.get(i);


                for (int j = 0; j < listCell.size(); j++) {
                    map.put(array[j], listCell.get(j));
                }
                //遍历map
                Set<String> set = map.keySet();
                Iterator<String> it = set.iterator();
                Driver.log.info("该组测试数据是：");
                while (it.hasNext()) {
                    String key = it.next();
                    String value = (String) map.get(key);
                    System.out.println(key + ":" + value);
                }

                //每读取一行用例后，返回给testcase调用
                if (mCallBackResult != null) {
                    mCallBackResult.setResult(map);
                }
            }
        }
    }

    // 验证excel文件
    public boolean validateExcel(String filePath) {
        // 检查文件名是否为空或者是否是Excel格式的文件
        if (filePath == null
                || !(is2003Excel(filePath) || is2007Excel(filePath))) {
            errorInfo = "文件名不是excel格式";
            return false;
        }
        // 检查文件是否存在
        File file = new File(filePath);
        if (file == null || !file.exists()) {
            errorInfo = "excel文件不存在";
            return false;
        }
        return true;
    }

    // 根据文件名读取excel文件

    public List<List<String>> readExcel(String filePath) {
        List<List<String>> dataList = new ArrayList<List<String>>();
        InputStream is = null;
        try {
            // 验证文件是否合法
            if (!validateExcel(filePath)) {
                System.out.println(errorInfo);
                return null;
            }
            // 判断文件的类型，是2003还是2007
            boolean is2003Excel = true;
            if (is2007Excel(filePath)) {
                is2003Excel = false;
            }
            // 调用本类提供的根据流读取的方法
            File file = new File(filePath);
            is = new FileInputStream(file);
            dataList = readFile(is, is2003Excel);
            is.close();
        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    is = null;
                    e.printStackTrace();
                }
            }
        }

        // 返回最后读取的结果
        return dataList;
    }

    // 根据流读取Excel文件

    public List<List<String>> readFile(InputStream inputStream, boolean is2003Excel) {
        List<List<String>> dataLists = null;
        try {
            // 根据版本选择创建Workbook的方式
            Workbook wb = null;
            if (is2003Excel) {
                wb = new HSSFWorkbook(inputStream);
            } else {
                wb = new XSSFWorkbook(inputStream);
            }
            // sheet循环
            int sheetNum = sheetCirculation(wb);
            List<List<String>> dataList = new ArrayList<List<String>>();
            if (readSheetNum) {
                dataLists = read(dataList, wb, readSheet);
            } else {
                for (int i = 0; i < sheetNum; i++) {
                    // Sheet sheet = wb.getSheetAt(i);
                    // 显示sheet名称
                    // System.out.println(sheet.getSheetName());
                    dataLists = read(dataList, wb, i);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataLists;
    }

    // 读取数据
    private List<List<String>> read(List<List<String>> dataList, Workbook wb,
                                    int sheets) {
        // 总行数
        int totalRows = 0;
        // 总列数
        int totalCells = 0;
        // 第一个shell页
        Sheet sheet = wb.getSheetAt(sheets);
        // Excel的行数
        totalRows = sheet.getPhysicalNumberOfRows();

        // Excel的列数
        if (totalRows >= 1 && sheet.getRow(0) != null) {
            totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }
        // 遍历Excel的行
        for (int r = 0; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }

            List<String> rowLst = new ArrayList<String>();

            // 遍历Excel的列
            for (int c = 0; c < totalCells; c++) {
                Cell cell = row.getCell(c);
                String cellValue = "";
                if (null != cell) {
                    // 以下是判断数据的类型
                    switch (cell.getCellType()) {
                        case HSSFCell.CELL_TYPE_NUMERIC: // 数字
                            cellValue = cell.getNumericCellValue() + "";
                            break;

                        case HSSFCell.CELL_TYPE_STRING: // 字符串
                            cellValue = cell.getStringCellValue();
                            break;

                        case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                            cellValue = cell.getBooleanCellValue() + "";
                            break;

                        case HSSFCell.CELL_TYPE_FORMULA: // 公式
                            cellValue = cell.getCellFormula() + "";
                            break;

                        case HSSFCell.CELL_TYPE_BLANK: // 空值
                            cellValue = "";
                            break;

                        case HSSFCell.CELL_TYPE_ERROR: // 故障
                            cellValue = "非法字符";
                            break;

                        default:
                            cellValue = "未知类型";
                            break;
                    }
                }
                rowLst.add(cellValue);
            }
            // 保存第r行的第c列
            dataList.add(rowLst);
        }
        return dataList;
    }

    private int sheetCirculation(Workbook wb) {
        int sheetCount = -1;
        sheetCount = wb.getNumberOfSheets();
        return sheetCount;
    }

    // 是否是2003的excel，返回true是2003

    public static boolean is2003Excel(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");

    }

    // 是否是2007的excel，返回true是2007
    public static boolean is2007Excel(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }

    // 构造方法
    public ImportExeclF() {
    }

    // 得到错误信息
    public String getErrorInfo() {
        return errorInfo;
    }

    /**
     * 设置Map数据的回调接口
     *
     * @param mCallBackResult 接口
     */
    public void setCallBackResult(CallBackResult mCallBackResult) {
        this.mCallBackResult = mCallBackResult;
    }
}
