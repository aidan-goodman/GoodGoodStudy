package 算法入门;

import java.util.Scanner;

public class 数组替换 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int b[] = new int[n];
        int a[] = new int[m + n];//注意数组大小
        for (int i = 0; i < m; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        int m1 = in.nextInt();
        int n1 = in.nextInt();
        int temp = m1;//储存m1
        for (int i = 0; i < n1; i++) {
            a[temp++] = b[i];//是temp++不是++temp，因为数组1指的就是第二个元素。
        }
        if (m - m1 < n1)
            m = m1 + n1;//改变之后a数组的大小
        for (int i = 0; i < m - 1; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.print(a[m - 1]);
    }
}
