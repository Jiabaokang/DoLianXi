package date_change;

public class Exceptions {
    public static void main(String[] args) {
        try {
            Class.forName("sss");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
