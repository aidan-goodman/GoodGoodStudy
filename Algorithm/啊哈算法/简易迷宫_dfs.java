package 啊哈算法.search;

import java.util.Scanner;

public class 简易迷宫_dfs {
    static int[][] arr = new int[50][50];//记录地图
    static int[][] book = new int[50][50];//记录走过的位置

    static int n, m, p, q;
    static int min = 99999;//记录最短步数

    static void dfs(int x, int y, int step) {//给定开始位置，记录所走的步数
        int[][] next = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//定义数组方便上线左右移动
        int tx, ty, k;
        if (x == p & y == q) {//到达指定位置
            if (step < min)//判断步数长度并更新
                min = step;
            return;//返回主调函数
        }

        for (int i = 0; i < 4; i++) {
            tx = x + next[i][0];//用next数组进行移动
            ty = y + next[i][1];
            if (tx < 0 || tx > n || ty < 0 || ty > m)//判断越界
                continue;//结束本次循环（非中止），进行下一种移动方式
            if (arr[tx][ty] == 0 && book[tx][ty] == 0) {//如果是空地且没走过
                book[tx][ty] = 1;
                dfs(tx, ty, step + 1);
                book[tx][ty] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int startx, starty;
        n = input.nextInt();
        m = input.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[n][m] = input.nextInt();
            }
        }
        startx = input.nextInt();
        starty = input.nextInt();
        p = input.nextInt();
        q = input.nextInt();
        dfs(startx, starty, 0);
        System.out.println(min);
    }
}
