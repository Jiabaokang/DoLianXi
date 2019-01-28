package com.utilsClass;

import com.utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginAndLogout {

    public static void login(WebDriver driver,String usrname,String pwd) throws InterruptedException {
        driver.get("http://www.baidu.com");
        Window.maxiWindow(driver);
        FindElement.byLinkText(driver, "登录").click();
        try {
            Wait.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //#TANGRAM__PSP_10__footerULoginBtn，//*[@id="TANGRAM__PSP_10__footerULoginBtn"]

        FindElement.byxpath(driver, "//*[@id='TANGRAM__PSP_10__footerULoginBtn']").click();//点击用户名登录
        Wait.implicitlyWait(driver,3);
        //清空用户名和密码 输入正确的，登录
        WebElement username = FindElement.byId(driver, "TANGRAM__PSP_10__userName");
        username.sendKeys(usrname);
        WebElement password = FindElement.byId(driver, "TANGRAM__PSP_10__password");
        password.sendKeys(pwd);
        FindElement.byId(driver, "TANGRAM__PSP_10__submit").click();

        Wait.sleep(10);
        try {
            WebElement msgtext = driver.findElement(By.xpath("//*[@id=\"TANGRAM__36__content_msgtext\"]"));
            String msg = msgtext.getText();
            if (msg.equals("您的帐号可能存在安全风险，为了确保为您本人操作，请先进行安全验证。")) {
                driver.findElement(By.xpath("//*[@id=\"TANGRAM__36__header_a\"]")).click();
            }
        } catch (Exception e) {
            System.out.println("没有找到验证码提示");
        }

        Wait.sleep(5);

        //重新登录
        driver.findElement(By.linkText("登录")).click();
        driver.findElement(By.id("TANGRAM__PSP_10__submit")).click();

        Wait.sleep(5);
        //验证是否登录成功
        String loginUser = driver.findElement(By.xpath("//*[@id=\"s_username_top\"]")).getText();
        Assert.assertEquals("sunny_ita", loginUser);

        //搜索：百度为您找到相关结果约4,570,000个

    }


    public static void logout(WebDriver driver) {
        WebElement name = FindElement.bycssSelector(driver, "#s_username_top > span");
        MouseActions actions = new MouseActions(driver);
        actions.moveToElement(name);
        Wait.implicitlyWait(driver,3);
        FindElement.bycssSelector(driver, "#s_user_name_menu > div > a.quit").click();
        Driver.log.info("logout>>>>>>>>>>>ok");
        driver.quit();
    }
}
