package com.functions;

import com.utilsClass.LoginAndLogout;
import com.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSearch {
    WebDriver driver;
    @BeforeTest
    public void itinDriver() {
        driver = Driver.getDriver();
    }


    @Test
    public void sousuo() throws InterruptedException {
        //登录
        String username="sunny_ita";
        String password="sunyi0814.";
        LoginAndLogout.login(driver,username,password);

        //搜索
        driver.findElement(By.id("kw")).sendKeys("testng");
        driver.findElement(By.id("su")).click();
        Thread.sleep(3000);
        String result = driver.findElement(By.cssSelector("#container > div.head_nums_cont_outer.OP_LOG > div > div.nums > span")).getText();
        boolean co = result.contains("百度为您找到相关结果约");
        Assert.assertTrue(co);

//        boolean a = RexUtil.isNumber(result);
//        Assert.assertTrue(a);
        //操作完后，初始化登录页面
        driver.findElement(By.cssSelector("#result_logo > img.s_lg_img_gold_show")).click();

        //退出登录
        LoginAndLogout.logout(driver);
    }

    @AfterTest
    public void quitDriver(){
        driver.quit();
    }

}
