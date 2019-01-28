package date_change;

import java.util.Random;

public class MathRondom {

            public static void main(String[] args) {
                //方法一：
                Random random=new Random();

                System.out.println( "random："+random.nextInt(100));

        //方法二：
        //调研产生随机数方法
        for(int i=0;i<10;i++){

            System.out.println("产生在2~23之间的随机偶数是：" + getOshu());
//            System.out.println(getishu());

        }
    }

    private static int getishu() {
        int i= (int) (20+Math.random()*(100-20));
        if(i%2==0){
            return i;
        }else{
            return i+1;
        }

    }

    private static int getOshu() {
        boolean b = true;
        int i;
        do {
            i = (int) (2 + Math.random() * (23 - 2));
            if (i % 2 == 0) {
                b = false;
                return i;
            }
        } while (b);
    return i;
    }

}
