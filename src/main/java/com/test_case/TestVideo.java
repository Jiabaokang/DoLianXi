package com.test_case;

import com.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestVideo {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = Driver.getDriver();

        driver.get("http://videojs.com/");

        driver.manage().window().maximize();

        WebElement videoButton = driver.findElement(By.xpath("//*[@id=\"preview-player\"]/button"));
        WebElement videoPlay=driver.findElement(By.xpath("//*[@id=\"preview-player_html5_api\"]"));
        videoButton.click();//播放10S
        Thread.sleep(10000);
        videoPlay.click();//暂停
        System.out.println("ok>>>>>>>>>");



    }
}
