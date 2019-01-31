package com.course.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ResourceBundle;

public class CookiesPostTest {
    private ResourceBundle bundle;
    private String hosturi;
    private CookieStore store;

    @BeforeMethod
    public void gethosturl() {
        bundle = ResourceBundle.getBundle("application");
        hosturi = bundle.getString("test.host.uri");
    }

    @Test
    public void getCookies() throws IOException {
        String parauri = bundle.getString("test.getCookies");
        String testUrl = this.hosturi + parauri;

        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        store = client.getCookieStore();
    }

    //将返回的store作为请求 给post的cookies
    @Test(dependsOnMethods = {"getCookies"})
    public void postWithPara() throws IOException {
        //获取 地址，post,client服务
        String parauri = bundle.getString("test.post.with.cookies");
        String testUrl = this.hosturi + parauri;
        HttpPost post = new HttpPost(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();

        //设置cookies
        client.setCookieStore(this.store);
        //设置headers
        post.setHeader("content-type", "application/json");
        //添加参数
        JSONObject param = new JSONObject();
        param.put("name", "huhansan");
        param.put("age", "18");
        //将参数放入stringEntity中,再添加到post
        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        post.setEntity(entity);
        //执行post请求,获取响应实体
        HttpResponse response = client.execute(post);
        //处理结果是否符合预期，查看json内容，断言value值
        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println("result==="+result);
        //获取响应码
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            //将返回的string内容转化为json对象
            JSONObject resultjson = new JSONObject(result);
            String success = resultjson.getString("huhansan");
            String status = resultjson.getString("status");
            Assert.assertEquals(success, "success");
            Assert.assertEquals(status, "1");
        }
    }

}
