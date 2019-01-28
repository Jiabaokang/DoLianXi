package date_change;


import java.util.*;

public class Person {
    String name;
    String age;

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");

        Iterator it = list.iterator();
        while (it.hasNext())
            System.out.print(it.next());


        HashMap map = new HashMap();
        map.put("1", "zhangsan");
        map.put("2", "lisi");
        System.out.println(map.get("1"));

        Set set = map.keySet();
        Iterator aa = set.iterator();
        while (aa.hasNext()) {
            String ke= (String) aa.next();
            String va= (String) map.get(ke);
            System.out.println(ke+":"+va);


        }
        System.out.println("=================");

        Collection mp=map.values();
        Iterator itd=mp.iterator();
        while (itd.hasNext()){
            System.out.println(itd.next());
        }
    }


}
