package com.utils;

import com.lianxi_selenium.ui.TestLog;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
public class Driver {
    public static Logger log = LoggerFactory.getLogger(TestLog.class);

    //获取谷歌浏览器驱动
    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "F:\\Intellij_idea\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
