package com.lianxi_selenium.ui;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 类说明
 *
 * @author iceb
 * @version $Id: SeTest.java, v0.1 2017/6/28.17:19 Exp $
 */

public class SeTest {

    @BeforeClass
    public void beforeClass() {
        System.out.println("用例前执行打印本句！");
        System.out.println("每条Test用例是互不相干的");
        System.out.println("用例开始执行…………");

    }

    @AfterClass
    public void afterClass(){
        System.out.println("用例结束后运行");
    }
    @Test
    public void actions() {
        //设置驱动所在位置:
        //F:\Intellij_idea\driver\chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "F:\\Intellij_idea\\driver\\chromedriver.exe");
        //引用谷歌浏览器驱动
        WebDriver driver = new ChromeDriver();
        //打开禅道界面
        driver.get("http://www.zentao.net/user-login.html");
        //以下元素使用css格式 -cssSelector
        //输入账号
        driver.findElement(By.cssSelector("#account")).sendKeys("sunny_ita");
        //输入密码
        driver.findElement(By.cssSelector("#password")).sendKeys("sunyi0814.");
        //点击登录
        driver.findElement(By.id("#submit")).click();

        //抓取成功登录后的用户名信息
        String text = driver.findElement(By.cssSelector("#siteNav > a:nth-child(4)")).getText();
        //断言-校验是否登录成功
        Assert.assertEquals(text,"懵");

        try {
            //页面等待
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //关闭浏览器进程及驱动
        driver.close();

    }

}