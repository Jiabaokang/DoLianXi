package com.testng.groups;

import org.testng.annotations.Test;

//类分组，Test标签卸载类名上

@Test(groups="stu")
public class GroupOnClass1 {
    public void stu1(){
        System.out.println("GroupOnClass1 >>>>>>>>>>>stu 111111");
    }

    public void stu2(){
        System.out.println("GroupOnClass1 >>>>>>>>>>>stu 22222");
    }
}
