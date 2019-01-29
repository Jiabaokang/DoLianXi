package com.testng;

import org.testng.annotations.Test;

public class Ignore {
    //忽略测试
    @Test(enabled = true)
    public void igonre1() {
        System.out.println("ignore1  1111");
    }

    @Test(enabled = false)
    public void igonre2() {
        System.out.println("ignore1  222");
    }
}
