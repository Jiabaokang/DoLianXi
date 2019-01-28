package date_change;

class Count {
    public int add(int a, int b) {
        return a + b;
    }


}


public class NewTest {
    public static void main(String[] args) {
        Count count=new Count();
       int c= count.add(3,7);
        System.out.println(c);
    }
}
