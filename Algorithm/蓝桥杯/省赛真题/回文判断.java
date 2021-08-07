package 算法入门;

import java.util.Scanner;

public class 回文判断 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        //5位或6位的截取一般都是3位数: 循环次数为 (29)*2 = 58
        //寻找5位的
        for (int a = 1; a <= 9; a++) {
            for (int b = 0; b <= 9; b++) {
                for (int c = 0; c <= 9; c++) {
                    if (2 * a + 2 * b + c == n) {
                        System.out.println("" + a + b + c + b + a);
                        count++;
                    }
                }
            }
        }
        //寻找6位的
        for (int a = 1; a <= 9; a++) {
            for (int b = 0; b <= 9; b++) {
                for (int c = 0; c <= 9; c++) {
                    if (2 * (a + b + c) == n) {
                        System.out.println("" + a + b + c + c + b + a);
                        count++;
                    }
                }
            }
        }
        if (count == 0)
            System.out.println(-1);
    }
}
