package com.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.Set;

public class Window{
    //浏览器窗口最大化
    public static void maxiWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }
    //获取当前窗口句柄
    public static String getWindowHandle(WebDriver driver){
        String currentWinHandle=driver.getWindowHandle();
        return currentWinHandle;
    }

    //获得所有窗口句柄
    public static Set<String> getWindowHandles(WebDriver driver){
      Set<String> handles= driver.getWindowHandles();
      return handles;
    }




    //获取各对话框的文本信息



//函数 getScreenshotAs()来截取当前窗口
    public static void getScreenshotAs(WebDriver driver){
//        long shijiancuo=System.currentTimeMillis()//给文件命名不重复
        try {
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(srcFile,new File("F:\\Intellij_idea\\LianXiShuJu\\screenshot"+shijiancuo+".png"));

            //生产相同的文件名会覆盖
            FileUtils.copyFile(srcFile,new File("F:\\Intellij_idea\\LianXiShuJu\\screenshot.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
