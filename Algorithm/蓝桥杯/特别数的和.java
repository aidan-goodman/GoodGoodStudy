package 省赛真题.T2019;

import java.util.Scanner;

public class 特别数的和 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ans = 0;
        int n = input.nextInt();
        for (int i = 1; i <= n; i++) {
            if (chech(i))
                ans += i;
        }
        System.out.println(ans);
    }

    private static boolean chech(int k) {
        while (k > 0) {
            if (k % 10 == 1 || k % 10 == 2 || k % 10 == 0 || k % 10 == 9) {
                return true;
            }//只判断个位数是否符合条件
            k /= 10;//不符合去掉个位再次判断
        }
        return false;
    }
}
