package com.test_case;

import com.utils.Driver;
import com.utils.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TestKeyboard {
    WebDriver driver;
    public  void testKeyboard() throws InterruptedException {
        driver= Driver.getDriver();
        driver.get("http://www.baidu.com");
        driver.manage().window().maximize();
        Wait.implicitlyWait(driver,3);

        //取得当前的title和url
        String url = driver.getCurrentUrl();
        String title = driver.getTitle();
        System.out.println(url);
        System.out.println(title);

        System.out.println(driver.findElement(By.id("su")).getAttribute("value"));

        System.out.println(driver.findElement(By.name("tj_briicon")).getText());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        /*
        WebElement input=driver.findElement(By.id("kw"));
        input.sendKeys("seleniumm");
        //回退删除一个m
        Thread.sleep(2000);
        input.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(2000);
        //输入空格
        input.sendKeys(Keys.SPACE);
        Thread.sleep(2000);
        input.sendKeys("教程");
        Thread.sleep(2000);
        input.sendKeys(Keys.CONTROL,"a");
        Thread.sleep(1000);
        input.sendKeys(Keys.CONTROL,"x");
        Thread.sleep(2000);
        input.sendKeys(Keys.CONTROL,"v");
        input.sendKeys(Keys.ENTER);*/

        driver.manage().timeouts().setScriptTimeout(5,TimeUnit.SECONDS);

    }

}
