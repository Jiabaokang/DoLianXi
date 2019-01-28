package com.test_case;

import com.utils.*;
import org.openqa.selenium.WebDriver;

public class TestMouse {
   static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        //鼠标悬停操作
        driver= Driver.getDriver();
        driver.get("http://www.baidu.com");
        Wait.sleep(2);
        Window.maxiWindow(driver);
        //将驱动作为参数传入action
//        Actions actions = new Actions(driver);
//        actions.moveToElement(driver.findElement(By.xpath("//div[@id='u1']/a[@name='tj_settingicon']"))).perform();
//        actions.moveToElement(driver.findElement(By.xpath("//div[@id='u1']/a[8]"))).perform();
//        actions.clickAndHold(driver.findElement(By.xpath("//div[@id='u1']/a[8]"))).perform();

//        WebElement userName = driver.findElemet(By.cssSelector(“form#form :nth-child(2)”));
// 冒号前有空格，定位到form下所有级别的第二个子元素

//actions.moveToElement(driver.findElement(By.cssSelector("#s_usersetting_top > span"))).perform();
        MouseActions mouse=new MouseActions(driver);
        mouse.clickAndHold(FindElement.byLinkText(driver,"设置"));
        mouse.doubleClick(FindElement.byLinkText(driver,"登录"));
        mouse.release();
//        actions.clickAndHold(driver.findElement(By.linkText("设置"))).perform();
//        actions.doubleClick(driver.findElement(By.linkText("登录"))).perform();
//        actions.release().perform();

    }
}
