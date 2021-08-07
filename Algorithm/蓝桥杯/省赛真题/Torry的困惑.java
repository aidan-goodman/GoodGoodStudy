package 算法入门;

import java.util.Scanner;

public class Torry的困惑 {
    public static void main(String[] args) {
        int count = 0;
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();//前n个质数
        long sum = 1;
        for (int i = 2; ; i++) {//第一个质数为2，不能判断前n个质数所在的范围
            int ok = 0;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    ok = 1;
                    break;
                }//如果不是质数，就标记为ok=1
            }
            if (ok == 0) {
                sum = (sum * i % 50000) % 50000;
                count++;
            }//如果是质数，让他参与运算，这是个公式，记住即可
            if (count == n) break;//前n个质数都被找到，跳出即可
        }
        System.out.println(sum);
    }
}
