package com.course.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyHttpClient {
    @Test
    public void getHttpClientResponse() throws IOException {
        //存在返回结果
        String result;
        //获得服务
        HttpGet get = new HttpGet("http://www.baidu.com");
        HttpClient client = new DefaultHttpClient();
        //执行请求，拿到返回结果
        HttpResponse response = client.execute(get);
        //处理返回结果：拿到实体，转换成string类型
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        Reporter.log("httpclient 返回内容：" + result);
//        System.out.println(result);
    }
}
