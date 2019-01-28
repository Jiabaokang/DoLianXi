package com.utils;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Wait{


    //固定的停n秒
    public static void sleep(int n) throws InterruptedException {
        Thread.sleep(n * 1000);
    }

    //页面加载n秒
    public static void pageLoadTimeout(WebDriver driver,int n) {
        driver.manage().timeouts().pageLoadTimeout(n, TimeUnit.SECONDS);
    }

    //异步加载n秒
    public static void setScriptTimeout(WebDriver driver,int n) {
        driver.manage().timeouts().setScriptTimeout(n, TimeUnit.SECONDS);
    }

    //等待元素查询n秒，未找到报异常
    public static void implicitlyWait(WebDriver driver,int n) {
        driver.manage().timeouts().implicitlyWait(n, TimeUnit.SECONDS);
    }

}
