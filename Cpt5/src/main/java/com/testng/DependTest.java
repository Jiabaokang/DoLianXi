package com.testng;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 若依赖的方法执行失败，会忽略后面的方法
 */

public class DependTest {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod");
    }



    @Test
    public void test1(){
        System.out.println("test1 run登录");
//        throw new RuntimeException();
    }

    @Test(dependsOnMethods ={"test1"})
    public void test2(){
        System.out.println("test2 run");
        throw new RuntimeException();
    }

    @Test(dependsOnMethods ={"test2"})
    public void test3(){
        System.out.println("test3 run");
    }

    @Test(dependsOnMethods ={"test2"})
    public void test4(){
        System.out.println("test4 run");
    }

}
