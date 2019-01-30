package com.testng.groups;

import org.testng.annotations.Test;

public class Timeouts {
    //超时，会失败
    @Test(timeOut = 3000)
    public void timeout() throws InterruptedException {
        System.out.println("333");
        Thread.sleep(4000);
    }

    //未超时，执行成功
    @Test(timeOut = 3000)
    public void timeoutSuccess() throws InterruptedException {
        System.out.println("333");
        Thread.sleep(3000);
    }
}
