package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElement{
//查找条件对象 By  8中方法
    public static WebElement byId(WebDriver driver,String idValue) {
        WebElement element = driver.findElement(By.id(idValue));
        return element;
    }

    public static WebElement byName(WebDriver driver,String nameValue) {
        WebElement element = driver.findElement(By.name(nameValue));
        return element;
    }

    public static WebElement byClassName(WebDriver driver,String args) {
        WebElement element = driver.findElement(By.className(args));
        return element;
    }

    public static WebElement byTagName(WebDriver driver,String args) {
        WebElement element = driver.findElement(By.tagName(args));
        return element;
    }

    public static WebElement byLinkText(WebDriver driver,String args) {
        WebElement element = driver.findElement(By.linkText(args));
        return element;
    }

    public static WebElement byPartialLinkText(WebDriver driver,String args) {
        WebElement element = driver.findElement(By.partialLinkText(args));
        return element;
    }

    public static WebElement byxpath(WebDriver driver,String args) {
        WebElement element = driver.findElement(By.xpath(args));

        return element;
    }

    public static WebElement bycssSelector(WebDriver driver,String args) {
        WebElement element = driver.findElement(By.cssSelector(args));
        return element;
    }
}
