package didi;

import java.util.Scanner;

/**
 * @author Aidan
 * @createTime 2021/10/23 16:59
 * @GitHub github.com/huaxin0304
 * @Blog aidanblog.top
 */

public class MinLen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), c = scanner.nextInt();
        int[][] map = new int[n + 1][n + 1];
        int[] visited = new int[n + 1];
        for (int i = 1; i <= n * (n - 1) / 2; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int len = scanner.nextInt();
            map[x][y] = len;
            map[y][x] = len;
        }
        // 所有楼都会间接可达，不用考虑入口，直接选择 1 号楼
        visited[1] = 1;
        int result = 0, step = 1, now = 0, min;
        while (step < n) {
            min = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                if (visited[i] == 1) {
                    // 选择没被连接的可达最小值
                    for (int j = 1; j <= n; j++) {
                        if (visited[j] == 0 && min > map[i][j]) {
                            min = map[i][j];
                            now = j;
                        }
                    }
                }
            }
            if (min != Integer.MAX_VALUE) {
                // 被连接后标识
                visited[now] = 1;
                result += min;
                step++;
            }
        }
        System.out.println(result * c);
    }
}
