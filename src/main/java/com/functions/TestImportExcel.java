package com.functions;

import com.utils.Driver;
import com.utilsClass.CallBackResult;
import com.utilsClass.ImportExeclF;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.HashMap;

public class TestImportExcel {

    static WebDriver driver;

    public static void main(String[] args){
        //输入excel 测试用例地址
        String excelPath="F:\\Intellij_idea\\LianXiShuJu\\interfaceTestcase.xlsx";

        try {
            ImportExeclF importExeclMain = new ImportExeclF();
            importExeclMain.setCallBackResult(new CallBackResult() {
                public void setResult(HashMap<String, String> map) throws InterruptedException {
                    runTest(map);
                }
            });
            importExeclMain.getExlContent(excelPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    private static void runTest(HashMap<String, String> map) throws InterruptedException {
        //搜索开始赋值：
        //搜索关键词，从Excel读取，参数map.get("keyword") 中的keyword的各参数字段名与Excel中对应的字段名一样
        String keyword= map.get("keyword");
        //预期结果，从Excel读取；map.get("expectContext")中的expectContext与Excel中对应的字段名一样
        String expectContext= map.get("expectContext");

        driver= Driver.getDriver();
        driver.get("http://www.baidu.com");//输入测试地址
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.id("kw")).sendKeys(keyword);  //搜索框中输入测试关键词
        driver.findElement(By.id("su")).click();            //点击搜索按钮


        Thread.sleep(3000);

        ////读取实际结果，获取对象的文本值：百度为您找到相关结果约7,160,000个
        WebElement element=driver.findElement(By.cssSelector("#container > div.head_nums_cont_outer.OP_LOG > div > div.nums > span"));
        String actureText=element.getText();

        //对比实际结果和预期结果（excel中读取的）
        boolean isTrue=actureText.contains(expectContext);
        Assert.assertTrue(isTrue);

        //关闭驱动
        driver.close();

    }

}
