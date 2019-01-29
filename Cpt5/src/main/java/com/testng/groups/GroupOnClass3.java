package com.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupOnClass3 {
    public void tea1(){
        System.out.println("GroupOnClass3 >>>>>>>>>>>tea1 111111");
    }

    public void tea2(){
        System.out.println("GroupOnClass3 >>>>>>>>>>>tea2 22222");
    }

}
