package date_change;

public class ObjectInstance  extends Object {
    public String toString() {
        return "重写了这个方法啦" + getClass().getName();

    }

    //重写toString 方法
    public static void main(String[] args) {
        ObjectInstance s=new ObjectInstance();
        s.toString();
    }
}
