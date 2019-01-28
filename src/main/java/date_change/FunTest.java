package date_change;

public class FunTest {
    public static void main(String[] args) {
        start();
        end();
        System.out.println(add(1,5));

    }

    private static void start() {
        System.out.println("start================");
        System.out.println("run>>>>>>>>>>>>");
    }
    public static void end(){
        System.out.println("end===================");
    };
    public static int add(int a,int b){
        return a+b;
    }
}
