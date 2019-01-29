package com.testng;

import org.testng.annotations.Test;

public class ExceptionTest {
    /**
     * 异常测试
     * 在我们预期某个结果为某个异常的时候
     */
    //这是一个测试结果会失败的测试
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFail() {
        System.out.println("这是结果会失败的异常测试");

    }

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess() {
        System.out.println("这是成功的异常测试");
        throw new RuntimeException();
    }
}
