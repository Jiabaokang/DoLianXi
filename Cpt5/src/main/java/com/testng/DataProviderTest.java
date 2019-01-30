package com.testng;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

public class DataProviderTest {
//    dataProvider 首字母小写

    @Test(dataProvider = "data")
    public void dataprovider(String name, int age) {
        System.out.println("name=" + name + ";age=" + age);
    }

    @DataProvider(name = "data")
    public Object[][] testdata() {
        Object[][] o = new Object[][]{
                {"zhangsan", 18},
                {"lisi", 20},
                {"wangwu", 30}
        };
        return o;
    }

    //第二个案例，通过方法传递参数
    @Test(dataProvider = "test")
    private void test1(String name, String age, String sex) {
        System.out.println("test111  name=" + name + ";age=" + age+";sex="+sex);
    }

    @Test(dataProvider = "test")
    private void test2(String name, String age) {
        System.out.println("test222  name=" + name + ";age=" + age);
    }

    @DataProvider(name = "test")
    public Object[][] testMethod(Method method) {
        Object[][] oo = null;
        if (method.getName().equals("test1")) {
            oo = new Object[][]{
                    {"zhangsan", "18", "nan"},
                    {"li", "20", "nv"}

            };
            return oo;

        } else if (method.getName().equals("test2")) {
            oo = new Object[][]{
                    {"wangwu", "70"},
                    {"zhaoliu", "73"}
            };
            return oo;
        }else {
            return null;

        }
    }

}