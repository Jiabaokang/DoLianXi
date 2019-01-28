package com.test_case;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.util.HashMap;

public class download {
    WebDriver driver;

    @Test
    public void testOne() throws Exception {
        //使用Chrome浏览器自动下载文件并保存到指定的文件路径
        //或 使用Selenium更改Chrome默认下载存储路径
        System.setProperty("webdriver.chrome.driver","F:\\Intellij_idea\\driver\\chromedriver.exe");
        //DesiredCapabilities 负责启动服务端时的参数设置
        //调用DesiredCapabilities类的setDownloadsPath（）方法，更改默认下载路径
        DesiredCapabilities caps = setDownloadsPath();
        driver = new ChromeDriver(caps);
        driver.manage().window().maximize();
        driver.get("https://pypi.org/project/selenium/#files");//到目标网页
        ////*[@id="files"]/table/tbody/tr[2]/td[1]/a[1]
        WebElement myElement = driver.findElement(By.xpath("//a[contains(text(),'selenium-3.141.0.tar.gz')]"));
        Actions action = new Actions(driver);
        myElement.click();//点击下载
        Thread.sleep(10000);
    }

    //单独重构成一个方法，然后调用
    public DesiredCapabilities setDownloadsPath() {
        String downloadsPath = "F:\\Intellij_idea\\LianXiShuJu";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", downloadsPath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        return caps;
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
// 然而AutoIt 来操作 Windows 控件进行下载，
}
