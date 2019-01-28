package com.test_case;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Elements {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "F:\\Intellij_idea\\driver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://pan.baidu.com/disk/home?errno=0&errmsg=Auth%20Login%20Sucess&&bduss=&ssnerror=0&traceid=#/all?path=%2F&vmode=list");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
//        WebElement element=driver.findElement(By.id("kw"));
//        System.out.println("获取输入框的宽度和高度:"+element.getSize());
//        System.out.println("获取元素的属性值："+element.getAttribute("name"));
//        System.out.println("该元素用户是否可见："+element.isDisplayed());
        driver.findElement(By.id("TANGRAM__PSP_4__footerULoginBtn")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("TANGRAM__PSP_4__userName")).sendKeys("sunny_ita");
        driver.findElement(By.id("TANGRAM__PSP_4__password")).sendKeys("sunyi0814.");
        driver.findElement(By.id("TANGRAM__PSP_4__submit")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"dialog1\"]/div[2]/div/div[2]/span")).click();

        //鼠标右键指定的元素
        Actions actions=new Actions(driver);

        actions.contextClick(driver.findElement(By.cssSelector("a[title='testSelenium'][class='npNRzZ']"))).perform();


    }
}
