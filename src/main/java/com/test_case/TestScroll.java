package com.test_case;

import com.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TestScroll {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = Driver.getDriver();

        driver.get("http://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("java");
        driver.findElement(By.id("su")).click();
        Thread.sleep(5000);
        //将页面滚动条拖到底部
        ((JavascriptExecutor) driver).executeScript("document.documentElement.scrollTop=10000");
        Thread.sleep(5000);
     //#将页面滚动条拖到顶部
        ((JavascriptExecutor) driver).executeScript("document.documentElement.scrollTop=0");
        System.out.println("end");
        driver.close();
    }
}
