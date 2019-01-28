package com.lianxi_selenium.ui;

import com.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginChanDao {
    static Logger logger = LoggerFactory.getLogger(TestLog.class);
    static WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver= Driver.getDriver();

        driver.get("https://www.zentao.net/user-login.html");
        //清空用户名密码
        driver.findElement(By.id("account")).clear();
        driver.findElement(By.id("password")).clear();

    }

    @Test
    public void login() throws InterruptedException {
        driver.findElement(By.id("account")).sendKeys("sunny_ita");
        driver.findElement(By.id("password")).sendKeys("sunyi0814.");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(3000);
        WebElement shouye = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div[2]/div/div[1]/text()"));
        System.out.println(shouye.getText().contains("欢迎您"));
    }

    @AfterTest
    public void quit(){
        driver.quit();
    }

}
