package com.testng;

import org.testng.annotations.*;

public class Byorder {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite...............");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite...............");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest...............");
    }

    @AfterTest
    public void AfterTest(){
        System.out.println("AfterTest...............");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass...............");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass...............");
    }



    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("BeforeMethod...............");
    }

    @AfterMethod
    public void AfterMethod(){
        System.out.println("AfterMethod...............");
    }

    @Test
    public void test2(){
        System.out.println("test2...............开始了");
    }

    @Test
    public void test1(){
        System.out.println("test1...............开始了");
    }
}
