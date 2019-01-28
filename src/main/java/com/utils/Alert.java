package com.utils;

import org.openqa.selenium.WebDriver;

public class Alert{
    /**
     * Alert 警告对话框：只有一个 “确定”按钮
     * Comfirmation 确认对话框：“确认”按钮 ， “取消”按钮
     * Prompt 输入对话框：“确认”按钮，“取消”按钮，文本框
     */

    //单击对话框的确认按钮，可以同时对 Alert,Confirmation,Prompt 使用
    public static void accept(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    //单击对话框的取消按钮，可以同时对 Confirmation,Prompt使用。
    public static void dismiss(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }


    //在弹出对话框中输入文本，改方法只对prompt 弹出对话框有效
    public static void sendKeys(WebDriver driver,String args) {
        driver.switchTo().alert().sendKeys(args);
    }

    //使用Text/getText()用户获取弹出对话框的文本内容
    public static String getText(WebDriver driver) {
        String alertText = driver.switchTo().alert().getText();
        return alertText;
    }

}
