package com.test_case;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class FileUpload {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","F:\\Intellij_idea\\driver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        File fileUrl=new File("F:/Intellij_idea/LianXiShuJu/upfile.html");
        String url=fileUrl.getAbsolutePath();
        driver.get(url);

        driver.findElement(By.name("file")).click();
        Thread.sleep(5000);
        //上传本次文件，通过AutoIt
        //1、首先识别控件，
        //2、编辑脚本，run保存au3文件
        //3、将au3文件转化为exe文件:F:\Intellij_idea\LianXiShuJu\\upfile.exe
        //接下来开始写脚本了runtime
        Runtime rn=Runtime.getRuntime();
        try {
            String filerl="D://upload_ch.exe";
            rn.exec(filerl);
            System.out.println("runtime exec ok========");
        } catch (IOException e) {
            System.out.println("runtime error>>>>>>>>>>");
        }
        Thread.sleep(10000);

       Long shijiancuo= System.currentTimeMillis();
        System.out.println("shijiancuo:"+shijiancuo);

        driver.quit();


    }
}
