package huaqi;

import java.util.Arrays;

/**
 * Created by Aidan on 2021/10/15 21:59
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class MinCostWithTimeLimited {
    public static void main(String[] args) {
        System.out.println(minCostWithTimeLimited(30,
                new int[][]{
                        {0, 1, 10},
                        {1, 2, 10},
                        {2, 5, 10},
                        {0, 3, 1},
                        {3, 4, 10},
                        {4, 5, 15}
                },
                new int[]{5, 1, 2, 20, 20, 3}));
    }

    public static int minCostWithTimeLimited(int maxTime, int[][] edges, int[] passingFees) {

        int n = passingFees.length; // 根据城市成本数组保留城市个数
        /*
        最大费用，这里根据数据规模计算
        可以使用 `Integer.MAX_VALUE - Arrays.stream(passingFees).max().getAsInt();`
        */
        int maxFee = (int) 1E6 + 1;
        // 创建时间限制同样规模的数组，保留从 0 到 i 需要的时间
        int[][] dp = new int[maxTime + 1][n];

        // 使用最大成本填充
        for (int i = 0; i <= maxTime; i++) {
            Arrays.fill(dp[i], maxFee);
        }

        // 起点花费
        dp[0][0] = passingFees[0];
        // 在时间限定中尝试
        for (int i = 1; i <= maxTime; i++) {
            for (int[] edge : edges) {
                // 耗时超过当前时间限定直接下一次循环
                if (edge[2] > i) {
                    continue;
                }
                int x = edge[0], y = edge[1], time = edge[2];
                // 根据边关系求出走这条路时的花费
                dp[i][x] = Math.min(dp[i][x], dp[i - time][y] + passingFees[x]);
                dp[i][y] = Math.min(dp[i][y], dp[i - time][x] + passingFees[y]);
            }
        }

        int ans = maxFee;
        for (int i = 0; i <= maxTime; i++) {
            ans = Math.min(ans, dp[i][n - 1]);
        }
        return (ans == maxFee) ? -1 : ans;
    }
}
