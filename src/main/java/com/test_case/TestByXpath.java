package com.test_case;

import com.utils.Driver;
import com.utils.Wait;
import com.utils.Window;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TestByXpath {
    static  WebDriver driver;
    public static void main(String[] args) throws InterruptedException {


        driver=Driver.getDriver();
        String s1 = "http://www.baidu.com";
        System.out.println("进入 s1地址:" + s1);
        driver.get(s1);
        Window.maxiWindow(driver);
        Wait.sleep(2);

        String s2 = "http://news.baidu.com/";
        System.out.println("进入s2地址:" + s2);
        driver.get(s2);
        Thread.sleep(2000);
        System.out.println("返回到s1");

        driver.navigate().back();
        String currentUrl1 = driver.getCurrentUrl();
        System.out.println("当前url=" + currentUrl1);
        Thread.sleep(2000);
        System.out.println("继续到s2");
        driver.navigate().forward();
        String currentUrl2 = driver.getCurrentUrl();
        System.out.println("当前url=" + currentUrl1);

        //回车操作
        driver.findElement(By.cssSelector("#ww")).sendKeys("test");


        driver.quit();

//
//
//
//        driver.findElement(By.cssSelector(".s_ipt")).sendKeys("test");
//        Thread.sleep(3000);
//        driver.findElement(By.cssSelector("#su")).click();
//        driver.close();

    }
}
