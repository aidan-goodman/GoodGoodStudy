package didi;

import java.util.Scanner;

/**
 * @author Aidan
 * @createTime 2021/10/23 16:33
 * @GitHub github.com/huaxin0304
 * @Blog aidanblog.top
 */

public class MaxScore {

    private static int result = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        /* dfs 调用
        for (int i = 0; i < arr.length; i++) {
            dfs(arr[i], i, arr, 1);
        }
        */
        dp(arr);
        System.out.println(result);


    }

    private static void dp(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[j] > arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[maxIndex] < dp[i]) {
                maxIndex = i;
            }
        }
        result = dp[maxIndex];
    }


    /* dfs 解法
    private static void dfs(int flag, int i, int[] arr, int count) {
        if (i + 1 == arr.length) {
            result = Math.max(result, count);
        }
        int j = i + 1;
        for (; j < arr.length; j++) {
            if (arr[j] < flag) {
                count++;
                dfs(arr[j], j, arr, count);
                count--;
            }
        }
        if (j == arr.length) {
            result = Math.max(result, count);
        }
    }
    */
}
