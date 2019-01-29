package com.testng.groups;

import org.junit.Before;
import org.testng.annotations.*;

public class GroupOnMethod {
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

    @Test
    public void test2(){
        System.out.println("test2...............开始了");
    }


    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("BeforeMethod...............");
    }

    @AfterMethod
    public void AfterMethod(){
        System.out.println("AfterMethod...............");
    }


    @Test(groups = "client")
    public void stu1(){
        System.out.println(">>>>>>>>>>>stu 111111");
    }

    @Test(groups = "server")
    public void tea1(){
        System.out.println(">>>>>>>>>>>tea 111111");
    }
    @Test(groups = "client")
    public void stu2(){
        System.out.println(">>>>>>>>>>>stu 22222");
    }
    @Test(groups = "server")
    public void tea2(){
        System.out.println(">>>>>>>>>>>tea 22222222");
    }
    @BeforeGroups("server")
    public void beforeGroupsOnmethod(){
        System.out.println("这是server 组运行之前 调用的方法");
    }

    @AfterGroups("server")
    public void afterGroups(){
        System.out.println("这是server 组运行之后调用的方法");
    }

    @BeforeGroups("client")
    public void beforeGroupsOnmethodclient(){
        System.out.println("这是client 组运行之前 调用的方法");
    }

    @AfterGroups("client")
    public void afterGroupsclient(){
        System.out.println("这是client 组运行之后调用的方法");
    }
}
