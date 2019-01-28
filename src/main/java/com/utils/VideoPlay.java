package com.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VideoPlay{
    public static void testVideo(WebDriver driver,WebElement videoElement) throws InterruptedException {
        //JS执行器
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //获得视屏的 URL
        jse.executeScript("return arguments[0].currentSrc;", videoElement);

        //播放视屏，播放 15 秒钟
        jse.executeScript("return arguments[0].play()", videoElement);
        Thread.sleep(15000);

        //暂停视屏
        jse.executeScript("arguments[0].pause()", videoElement);


    }
}
