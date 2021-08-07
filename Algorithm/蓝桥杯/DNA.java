package 算法入门;

import java.util.Scanner;

public class DNA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        for (int k = 0; k < n; k++) {//组数
            for (int i = 0; i < a[k] * b[k]; i++) {//单组总行数
                if (i % a[k] == 0 && i != 0) {
                    i++;//判断组结束，因为每组的第一行是上一组的最末行
                }
                for (int j = 0; j < a[k]; j++) {//单行内容
                    if (j == i % a[k] || j == (a[k] - i % a[k] - 1)) {//判断输出内容
                        System.out.print("X");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();//单行换行
            }
            System.out.println();//一组换行
        }
    }
}
