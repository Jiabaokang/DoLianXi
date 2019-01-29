package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestsuitDriver {
    static WebDriver driver;

    @BeforeSuite
    public static WebDriver beforeSuite(){
        //加载驱动
        System.setProperty("webdriver.chrome.driver", "F:\\Intellij_idea\\driver\\chromedriver.exe");
         driver = new ChromeDriver();
        System.out.println("BeforeSuite加载驱动OK");
        driver.get("http://www.baidu.com");
        return driver;
    }

    @AfterSuite
    public static void afterSuite(){
        driver.quit();
        //退出驱动
        System.out.println("AfterSuite退出驱动");

    }

    @BeforeTest
    public static void beforeTest() throws InterruptedException {
        //登录功能
        Thread.sleep(5000);
        driver.get("http://www.baidu.com");
        System.out.println("beforeTest登录成功");
    }

    @AfterTest
    public static void afterTest(){
        //退出登录
        driver.get("http://www.baidu.com");
        System.out.println("afterTest.退出登录");
    }



}
