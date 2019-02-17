package com.tesngExtentReport;

import org.testng.Assert;
        import org.testng.Reporter;
        import org.testng.annotations.Test;

public class TestExtentReport {
    @Test
    public void test1(){
        Assert.assertEquals(1,2);
    }
    @Test
    public void test2(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void test3(){
        Assert.assertEquals("aaa","aaa");
    }
    @Test
    public void logDemo(){
        Reporter.log("这是一个我自己写的demo");
        throw new RuntimeException("自己写的运行时异常啦！");
    }
}
