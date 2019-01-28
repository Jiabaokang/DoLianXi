package date_change;

public class MaoPao {


    public static void main(String[] args) {
        int a[] = {3573, 234, 23, 6, 21, 4};

        MaoPao maoPao = new MaoPao();
        maoPao.getArrays(a);

        System.out.println( "class是："+Object.class.getName());


    }

    private void getArrays(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length-i; j++) {
                if (a[j] > a[j + 1]) {
                    int b = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = b;
                }
            }
        }
        binaLi(a);

    }

    private void binaLi(int[] a) {
        for(int e:a){
            System.out.print(">"+e);
        }
    }


}
