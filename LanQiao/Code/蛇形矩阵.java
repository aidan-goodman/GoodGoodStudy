package 算法入门;

import java.util.Scanner;

public class 蛇形矩阵 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = 1, m = 1;//a为每行的第一个元素，m为每列第一个元素之间的差
        for (int i = n; i >= 0; i--) {//控制行数
            int s = m + 1, b = a;//s为每行相邻元素的差
            for (int j = 1; j <= i; j++) {//每行的元素
                System.out.print(b + " ");
                b += s;//每次加差
                s++;//每次加1
            }
            System.out.println();
            a += m;//改变第一个元素的值
            m++;//每次加1
        }
    }
}