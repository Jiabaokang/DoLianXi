package com.test_case;

import com.utils.Cookies;
import com.utils.Driver;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class TestGetCookies {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = Driver.getDriver();
        //F:\Intellij_idea\LianXiShuJu
//        File file=new File("F:\\Intellij_idea\\LianXiShuJu\\upfile.html");
//        String fi=file.getAbsolutePath();
        driver.get("http://www.baidu.com");
        Thread.sleep(5000);

        //获取cookies，再遍历
        IteratorCookies();

        Driver.log.info("添加cookies>>>>>>>>>>>>>>>>");
//       Cookie c1= new Cookie("login","true");
//        Cookie c2= new Cookie("zhangsan","20");
//        driver.manage().addCookie(c1);
//        driver.manage().addCookie(c2);
        Cookies.addCookies(driver,"login","true");
        Cookies.addCookies(driver,"zhangsan","20");
        IteratorCookies();

        Driver.log.info("删除cookies>>>>>>>>>>>>>>>>");
        Cookies.deleteAllCookie(driver);
        IteratorCookies();

//        driver.get("http://www.baidu.com");
//        Wait.sleep(2);
//        //获得 cookie
//        String currentHandle = Window.getWindowHandle();
//        System.out.println("currentHandle=" + currentHandle);
//        Set<Cookie> coo = CookiesSet.getCookis();
//        //打印 cookie
//        System.out.println(coo);
//        for (Cookie co : coo) {
//            //打印 cookie
//            System.out.println(co);
//            System.out.println("co.getName():" + co.getName());
//            System.out.println("co.getValue():" + co.getValue());
//            System.out.println("co.toString():" + co.toString());
//        }
//        driver.quit();

    }

    private static void IteratorCookies() {
        Set<Cookie> cookies= Cookies.getCookis(driver);
        for(Cookie cookie:cookies){
            System.out.println(cookie);
        }
    }
}
