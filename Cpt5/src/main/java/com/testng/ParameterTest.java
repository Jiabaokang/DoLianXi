package com.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
    @Test
    @Parameters({"name", "age"})
    public void para1(String name, String age) {
        System.out.println(name + "===" + age);
    }


}
