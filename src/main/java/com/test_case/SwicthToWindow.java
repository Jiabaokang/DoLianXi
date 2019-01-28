package com.test_case;

import com.utils.Driver;
import com.utils.Wait;
import org.openqa.selenium.WebDriver;

public class SwicthToWindow {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        driver=Driver.getDriver();

        driver.get("http://www.baidu.com");
        Driver.log.info("进入百度了>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("当前handle="+driver.getWindowHandle());
        Wait.implicitlyWait(driver,2);

        driver.get("http://news.baidu.com/");
        Driver.log.info("进入新闻了>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("当前handle="+driver.getWindowHandle());
        Wait.implicitlyWait(driver,2);

        driver.get("https://zhidao.baidu.com/");
        Driver.log.info("进入知道了>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("当前handle="+driver.getWindowHandle());
        Wait.implicitlyWait(driver,2);




















  /*        FindElement.byLinkText("登录").click();
        Wait.sleep(2);
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.linkText("立即注册")).click();

        //获得所有窗口句柄
            Set<String> handles = driver.getWindowHandles();
        //判断是否为注册窗口，并操作注册窗口上的元素
      for (String handle : handles) {

            if (handle.equals(searchPage) == false) {
                //切换到注册页面
                driver.switchTo().window(handle);
                System.out.println("可以注册了");
                Thread.sleep(2000);
            }
            driver.close();
        }

        for (String handle : handles) {
            if (handle.equals(searchPage)) {
                driver.switchTo().window(handle);
                Thread.sleep(3000);
            }
        }
        driver.quit();*/
    }
}
