package date_change;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class PrintXxAndMap {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {

            for (int j = 5 - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int m = 1; m <= 2 * i - 1; m++) {
                System.out.print("*");
            }

            System.out.println();

        }

        //

        String zmsz[] = {"s", "e", "d"};

        for (String sm : zmsz) {
            System.out.println(sm);
        }

        HashMap map = new HashMap<String,String>();
        map.put("1", "zhangsan");
        map.put("2", "lisi");
        map.put("3", "wangsu");
        map.put("4", "zhaowu");
        System.out.println("是否包含key：");
        System.out.println(map.containsKey("1"));
        System.out.println(map.containsKey("5"));
        System.out.println("是否包含value:");
        System.out.println(map.containsValue("zhangsan"));
        System.out.println(map.containsValue("zhu"));
        System.out.println("找出对应的key对应的value");
        System.out.println(map.get("1"));

        System.out.println("打印每一对key-value:");
        System.out.println(map.entrySet());

        System.out.println("遍历keyset");
        Set set=map.keySet();
        Iterator it=set.iterator();
        while (it.hasNext()){

            System.out.println(it.next());
        }
        Iterator its=map.values().iterator();

        while(its.hasNext()){
            System.out.println(its.next());
        }


        System.out.println("分别打印每一个key和value");
        Iterator it3=map.keySet().iterator();
        while (it3.hasNext()){
            String id= (String) it3.next();
//            System.out.println(id);
            String name= (String) map.get(id);
//            System.out.println(name);
            System.out.println(id+":"+name);

        }





    }
}
