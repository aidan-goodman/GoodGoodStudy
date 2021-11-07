package didi;

import java.util.Scanner;

/**
 * Created by Aidan on 2021/10/23 16:33
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

/*
小明和小花在玩一个删除数字的游戏。 游戏规则如下：
首先随机写下N个正整数，然后任选一个数字作为起始点，从起始点开始从左往右每次可以删除一个数字，
但是必须满足下一个删除的数字要小于上一个删除的数字。每成功删除一个数字计1分。
请问对于给定的N个正整数，一局游戏过后可以得到的最大计分是多少？
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
