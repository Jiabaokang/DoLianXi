package com.utils;

import lombok.Data;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

@Data
public class Cookies{


    //添加cookies
    public static void addCookies(WebDriver driver,String name, String value){
        Cookie cookie1=new Cookie(name,value);
        driver.manage().addCookie(cookie1);
    }

    //删除所有cookies
    public static void deleteAllCookie(WebDriver driver){
      driver.manage().deleteAllCookies();
    }

    //获取cookies
    public static   Set<Cookie> getCookis(WebDriver driver) {
        Set<Cookie> cookies = driver.manage().getCookies();
        return cookies;
    }

}
