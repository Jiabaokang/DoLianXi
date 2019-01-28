package com.functions;

import com.utils.Driver;
import com.utilsClass.LoginAndLogout;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLonginAndLogout {
    WebDriver driver;
    @BeforeTest
     void intDriver(){
        driver= Driver.getDriver();
    }

    @Test
     void loginBaidu() throws InterruptedException {
        String username="sunny_ita";
        String password="sunyi0814.";
        LoginAndLogout.login(driver,username,password);
    }

    @Test(dependsOnMethods = {"loginBaidu"})
     void logoutBaidu(){
        LoginAndLogout.logout(driver);
    }

    @AfterTest
     void quitDriver(){
        driver.quit();
    }

}
