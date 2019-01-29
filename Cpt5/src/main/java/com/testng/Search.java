package com.testng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Search {
    @BeforeMethod
    public void shouye(){
        System.out.println("get首页地址");
    }

    @Test
    public void chaxun1() {
        System.out.println("搜索到了要的商品了---------111111111");
    }

    @Test
    public void chaxun2() {
        System.out.println("搜索到了要的商品了--------222222222");
    }
}
