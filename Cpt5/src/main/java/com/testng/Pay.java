package com.testng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Pay {
   public static  WebDriver driver=TestsuitDriver.beforeSuite();
    @BeforeMethod
    public void shouye(){
        driver.get("http://www.baidu.com");
        System.out.println("进入支付页面");
    }
    @Test
    public void zhifu(){
        driver.get("http://www.baidu.com");
        System.out.println("支付宝支付成功了");
    }
}
