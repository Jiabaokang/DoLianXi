package com.test_case;

import com.utils.Driver;
import com.utils.Window;
import org.openqa.selenium.WebDriver;

public class TestTakesScreenshot {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        driver= Driver.getDriver();
        Thread.sleep(3000);
        driver.get("http://www.baidu.com");

        Window.getScreenshotAs(driver);


    }
}
