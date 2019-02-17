package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/",description = "这是我全部的get请求")
public class MyGetMethod {
    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    @ApiOperation(value = "获取cookies的方法",httpMethod = "GET")
    public String getcookies(HttpServletResponse response) {
        //HttpServletRequest 装请求信息的类
        //HtppServletResponse 装响应信息的类

        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "恭喜你获取cookies成功";
    }

    /*
    要求携带cookies信息才能访问的接口
     */
        @RequestMapping(value = "get/with/cookies", method = RequestMethod.GET)
        @ApiOperation(value = "要求携带cookies信息才能访问的接口",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request) {
        javax.servlet.http.Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "请你携带cookies信息来吧";
        }
        for (javax.servlet.http.Cookie cookie : cookies) {
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
                return "恭喜你携带cookies访问get请求成功。";
            }
        }
        return "请你携带cookies信息来吧";
    }

    /*
    开发一个需要携带参数才能访问的get请求
    第一种实行方式 url:key=value&key=value
    浏览器中输入：http://localhost:8080/get/with/param?start=1&end=2
    我们来模拟商品列表接口，若翻页接口
    */
    @RequestMapping(value = "/get/with/param", method = RequestMethod.GET)
    @ApiOperation(value = "开发一个需要携带参数才能访问的get请求url:key=value&key=value",httpMethod = "GET")
    private Map<String, Integer> getList(@RequestParam Integer start,
                                         @RequestParam Integer end) {
        Map<String, Integer> mylist = new HashMap<>();
        //实际上是去数据库里面取值,目前我们采取赋值
        mylist.put("xie", 400);
        mylist.put("gancuimian", 1);
        mylist.put("chushan", 200);

        return mylist;
    }

    /*
    开发一个需要携带参数才能访问的get请求
    第二种需要携带参数访问的get请求
    url:ip:port:get/with/param/10/20
   浏览器中输入：http://localhost:8080/get/with/param/1/2
     */
    @RequestMapping("/get/with/param/{start}/{end}")
    @ApiOperation(value = "第二种需要携带参数访问的get请求,/get/with/param/{start}/{end}",httpMethod = "GET")
    public Map<String ,Integer> myGetList(@PathVariable Integer start,
                         @PathVariable Integer end) {
        Map<String, Integer> mylist = new HashMap<>();
        //实际上是去数据库里面取值,目前我们采取赋值
        mylist.put("鞋子", 400);
        mylist.put("干脆面", 1);
        mylist.put("村山", 200);

        return mylist;
    }

}
