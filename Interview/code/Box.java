package meituan;

import java.util.Scanner;

/**
 * Created by Aidan on 2021/10/17 10:09
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class Box {
    public static void main(String[] args) {
        final int MOD = 1000000007;

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] counts = new int[n + 1];
        int[] kinds = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            counts[i] = scanner.nextInt();
        }
        for (int i = 2; i <= n; i++) {
            kinds[i] = scanner.nextInt();
        }
        int[] result = new int[n + 1];
        result[1] = 1;

        for (int i = 2; i <= n; i++) {
            int count = counts[i];
            int kind = kinds[i];
            long res = (long) count * (long) result[kind];
            result[i] = (int) (res % MOD);
        }
        for (int i = 1; i < result.length - 1; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.print(result[result.length - 1]);
    }
}
