package didi;

import java.util.Scanner;

/**
 * Created by Aidan on 2021/10/23 16:59
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

/*
X星大学新校区终于建成啦！  新校区一共有N栋教学楼和办公楼。
现在需要用光纤把这N栋连接起来，保证任意两栋楼之间都有一条有线网络通讯链路。
已知任意两栋楼之间的直线距离（单位：千米）。为了降低成本，要求两栋楼之间都用直线光纤连接。
光纤的单位成本C已知（单位：X星币/千米），
请问最少需要多少X星币才能保证任意两栋楼之间都有光纤直接或者间接相连？
注意：如果1号楼和2号楼相连，2号楼和3号楼相连，则1号楼和3号楼间接相连
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

        visited[1] = 1;   // 所有楼都会间接可达，不用考虑入口，直接选择 1 号楼
        int result = 0, step = 1, now = 0, min;
        while (step < n) {
            min = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                if (visited[i] == 1) {
                    for (int j = 1; j <= n; j++) {  // 选择没被连接的可达最小值
                        if (visited[j] == 0 && min > map[i][j]) {
                            min = map[i][j];
                            now = j;
                        }
                    }
                }
            }
            if (min != Integer.MAX_VALUE) {
                visited[now] = 1;     // 被连接
                result += min;
                step++;
            }
        }
        System.out.println(result * c);
    }
}
