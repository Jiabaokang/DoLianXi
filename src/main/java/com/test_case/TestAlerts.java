package com.test_case;

import com.utils.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class TestAlerts {
    WebDriver driver;
    public  void test() throws InterruptedException {
        driver=Driver.getDriver();

        driver.get("http://www.baidu.com");
        Window.maxiWindow(driver);
        Wait.implicitlyWait(driver,3);
        //获取设置
        WebElement shezhi = FindElement.byLinkText(driver,"设置");
        Wait.implicitlyWait(driver,5);

    MouseActions mouse=new MouseActions(driver);
        mouse.moveToElement(shezhi);
        FindElement.byClassName(driver,"setpref").click();
        Wait.sleep(3);

    //保存设置
//        driver.findElement(By.className("prefpanelgo")).click();
//        driver.findElement(By.xpath("//div[@id='gxszButton']/a")).click();
        FindElement.bycssSelector(driver,"div[id='gxszButton']>a[class='prefpanelgo']").click();
        Wait.setScriptTimeout(driver,2);
        Alert.accept(driver);
        Driver.log.info("Ok===============");

        driver.quit();

}
}
