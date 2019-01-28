package com.utils;

import java.io.IOException;


public class AutoIt extends Driver {

    //fileUrl:本地exe文件的存在路径
    public static void upload(String fileUrl) throws InterruptedException {
        //上传本次文件，通过AutoIt
        //1、首先识别控件，
        //2、编辑脚本，run保存au3文件
        //3、将au3文件转化为exe文件:F:\Intellij_idea\LianXiShuJu\\upfile.exe
        //接下来开始写脚本了runtime
        Runtime rn = Runtime.getRuntime();
        try {
//            String filerl = "D://upload_ch.exe";
            rn.exec(fileUrl);
            log.info("文件上传成功>>>>>>>>>>>>>>>>");
        } catch (IOException e) {
            log.info("文件上传失败>>>>>>>>>>");
        }
        Thread.sleep(5000);
    }

    //saveUrl:保存到本地的路径
    public static void downLoad(String saveUrl){
        Runtime rn=Runtime.getRuntime();

        try {
            rn.exec(saveUrl);
            log.info("文件下载成功>>>>>>>>>>>>>>>>");
        } catch (IOException e) {
            log.info("文件下载失败>>>>>>>>>>>>>>>>");
        }

    }

}
