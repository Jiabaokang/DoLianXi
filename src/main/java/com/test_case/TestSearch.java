package com.test_case;

import com.lianxi_selenium.ui.TestLog;
import com.utils.FindElement;
import com.utils.Driver;
import com.utils.Wait;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSearch {
    Logger log = LoggerFactory.getLogger(TestLog.class);
    WebDriver driver;
    String testUrl="http://baidu.com";

    @BeforeTest
    public void loginShouye() throws InterruptedException {
        driver = Driver.getDriver();
        log.info("驱动加载开始了>>>>>>>>>>>>>>>>>>>>>>>");
        driver.get(testUrl);
        log.info("成功进入testUrl:"+testUrl);
        Wait.sleep(5);
    }

    @Test
    public void testSearch() throws InterruptedException {
        //搜索
        FindElement.byId(driver,"kw").sendKeys("selenium java");
        FindElement.byId(driver,"su").click();
        Wait.sleep(3);
    }

    @AfterTest
    public void logoutShouye() {
        driver.close();
        log.info("logoutShouye成功>>>>>>>>>>>>>>>>>>>");
    }

}
