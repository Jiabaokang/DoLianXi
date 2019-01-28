package com.utils;

        import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.WebDriver;

public class JSscroll {
    //操作滚动条,将页面滚动条拖到底部
    public static void scrollToEnd(WebDriver driver) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("document.documentElement.scrollTop=10000");
        Thread.sleep(3000);
    }

    //操作滚动条,将页面滚动条拖到顶部
    public static void scrollToTop(WebDriver driver) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("document.documentElement.scrollTop=0");
        Thread.sleep(3000);
    }
}
