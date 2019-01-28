package date_change;

import java.util.Arrays;

public class ShuZu {
    public static void main(String[] args) {
        int arr[][] = new int[][]{{1, 5}, {2, 4}};
        for (int x[] : arr) {
            for (int a : x) {
                System.out.print(a);
            }
            System.out.println();
        }


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();

        }

        int t[] = new int[5];
        Arrays.fill(t, 8);
        for (int j = 0; j < t.length; j++) {
            System.out.println(t[j]);
        }

        int a[] = new int[]{2, 5, 1, 0, 6};
        Arrays.sort(a);
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(a[i]);
        }
        System.out.println("==============================================");

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                int emp = 0;
                if (a[j] > a[j + 1]) {
                    emp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = emp;

                }

            }

        }

        for (int e : a) {
            System.out.print(e);
        }
    }
}
