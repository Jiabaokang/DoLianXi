package com.utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Robot{
    /**
     * sendKeys(Keys.BACK_SPACE) 删除键（BackSpace）
     * sendKeys(Keys.SPACE) 空格键(Space)
     * sendKeys(Keys.TAB) 制表键(Tab)
     * sendKeys(Keys.ESCAPE) 回退键（Esc）
     * sendKeys(Keys.ENTER) 回车键（Enter）
     * sendKeys(Keys.CONTROL, "a" ) 全选（Ctrl+A）
     * sendKeys(Keys.CONTROL, "c" ) 复制（Ctrl+C）
     * sendKeys(Keys.CONTROL, "x" ) 剪切（Ctrl+X）
     * sendKeys(Keys.CONTROL, "v" ) 粘贴（Ctrl+V）
     * sendKeys(Keys.F1) 键盘 F1
     * ……
     * sendKeys(Keys.F12) 键盘 F12
     */
    //删除文本内容最后一个字符
    public static void backSpace(WebElement element) {
        element.sendKeys(Keys.BACK_SPACE);
    }

    //sendKeys(Keys.SPACE) 空格键(Space)
    public static void space(WebElement element) {
        element.sendKeys(Keys.SPACE);
    }

    //sendKeys(Keys.TAB) 制表键(Tab)
    public static void tab(WebElement element) {
        element.sendKeys(Keys.TAB);
    }

    //sendKeys(Keys.ESCAPE) 回退键（Esc）
    public static void escape(WebElement element) {
        element.sendKeys(Keys.ESCAPE);
    }

    // 回车键（Enter）
    public static void enter(WebElement element) {
        element.sendKeys(Keys.ENTER);
    }

    //sendKeys(Keys.CONTROL, "a" ) 全选（Ctrl+A）
    public static void ctrlA(WebElement element) {
        element.sendKeys(Keys.CONTROL, "a");
    }

    //sendKeys(Keys.CONTROL, "c" ) 复制（Ctrl+C）
    public static void ctrlC(WebElement element) {
        element.sendKeys(Keys.CONTROL, "c");
    }

    //sendKeys(Keys.CONTROL, "x" ) 剪切（Ctrl+X）
    public static void ctrlX(WebElement element) {
        element.sendKeys(Keys.CONTROL, "x");
    }

    // sendKeys(Keys.CONTROL, "v" ) 粘贴（Ctrl+V）
    public static void ctrlV(WebElement element) {
        element.sendKeys(Keys.CONTROL, "v");
    }

    //send_keys(Keys.F1) 键盘 F1...F12
    public static void f1(WebElement element) {
        element.sendKeys(Keys.F1);
    }

}
