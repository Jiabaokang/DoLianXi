package com.course.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

//运行这个class，需要先启动mock下的startupWithCookies.json文件
//读取/getCookies的cookie ，给/get/with/cookies 提供入参
public class CookiesTest {
   private ResourceBundle bundle;
    private String hosturi;
    //用来存储cookies信息的变量
    private CookieStore cookieStore;

    @BeforeMethod
    public void getbundle() {
        //读取resource下的properties文件
        bundle = ResourceBundle.getBundle("application");
        hosturi = bundle.getString("test.host.uri");
    }

    @Test
    public void returnCookies() throws IOException {
        //获取/getCookies服务的uri,拼接成testUrl
        String parauri = bundle.getString("test.getCookies");
        String testUrl = this.hosturi + parauri;
        //获取服务
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        //返回实体
        HttpResponse response = client.execute(get);
        //获取实体信息
        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);

        //查看返回的cookies信息
        cookieStore = client.getCookieStore();
        List<Cookie> cookies = cookieStore.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("name=" + name + ";value=" + value);
        }

    }

    @Test(dependsOnMethods = {"returnCookies"})
    public void getWithCookies() throws IOException {
        //拿到startupWithCookies.json中的“这是一个带cookies信息的get请求”的 "uri": "/get/with/cookies",
        String paraUri = bundle.getString("test.get.with.cookies");
        String testUrl = this.hosturi + paraUri;
        //获取服务
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        //设置cookies信息
        client.setCookieStore(this.cookieStore);
        //执行请求
        HttpResponse response = client.execute(get);
        //获取返回实体内容
        int code = response.getStatusLine().getStatusCode();
        System.out.println("statusCode=" + code);

        if (code == 200) {
            String result = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(result);
        }
    }
}
