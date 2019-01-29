package com.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupOnClass2 {
    public void stu1(){
        System.out.println("GroupOnClass2 >>>>>>>>>>>stu 111111");
    }

    public void stu2(){
        System.out.println("GroupOnClass2 >>>>>>>>>>>stu 22222");
    }
}
