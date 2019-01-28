package com.utils;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@Data
public class MouseActions{
    /**
     *  contextClick() 右击
     *  clickAndHold() 鼠标悬停
     *  move_to_element() 鼠标悬停
     *  doubleClick() 双击
     *  dragAndDrop() 拖动
     *  release() 释放鼠标
     *  perform() 执行所有 Actions 中存储的行为
     */
     Actions actions;

    public MouseActions(WebDriver driver) {
        actions = new Actions(driver);
    }

    //contextClick() 右击
    public  void contextClick(WebElement element) {

        actions.contextClick(element).perform();
    }

    //clickAndHold() 鼠标悬停
    public  void clickAndHold(WebElement element) {
        actions.clickAndHold(element).perform();
    }

    public  void moveToElement(WebElement element) {
        //move_to_element() 鼠标悬停
        actions.moveToElement(element).perform();
    }

    //doubleClick() 双击
    public  void doubleClick(WebElement element){
        actions.doubleClick(element).perform();
    }

    //dragAndDrop() 拖动
    public  void dragAndDrop(WebElement source,WebElement target){
        actions.dragAndDrop(source,target).perform();
    }

    //release() 释放鼠标
    public  void release(){
        actions.release().perform();
    }






}
