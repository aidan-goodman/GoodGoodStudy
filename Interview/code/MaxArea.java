package threesixzero;

import java.util.Scanner;

/**
 * Created by Aidan on 2021/10/24 16:24
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class MaxArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int group = scanner.nextInt();
        for (int i = 0; i < group; i++) {
            int m = scanner.nextInt(), n = scanner.nextInt();
            int[][] area = new int[m][n];
            int max = Integer.MIN_VALUE, site = Math.min(m, n);
            for (int i1 = 0; i1 < m; i1++) {
                for (int i2 = 0; i2 < n; i2++) {
                    area[i1][i2] = scanner.nextInt();
                }
            }
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l <= site && l + j < m && l + k < n; l++) {
                        max = Math.max(getMaxSum(area, j, k, l), max);
                    }

                }
            }

            System.out.println(max);
        }
    }

    public static int getMaxSum(int[][] arr, int startX, int startY, int site) {
        int count = 0;
        for (int i = startX; i < startX + site; i++) {
            for (int j = startY; j < startY + site; j++) {
                count += arr[i][j];
                if (arr[i][j] == -1) {
                    return 0;
                }
            }
        }
        return count;
    }
}

/*  未完成
   一日，小A走在路上时看到路边摆着一面大镜子。他对着这面镜子注视了半天，突然发现自己穿越到了另一个世界！

   这个世界很奇怪：他所在的地方可视为一个n行m列的矩阵，每一个位置上都有一个非负整数或者-1。这时，他的耳边响起了一个很空灵的声音：“如果您想要回到原来的世界，你需要解决下面的问题：你需要在整个矩阵上选择一个正方形区域，使得该区域不包含任何负数，并且该区域内的数字之和最大。”

   然而这个问题对于小A来说还是太难了，所以他请了你来帮忙解决这个问题。



输入描述
第一行一个正整数T，表示一共有T组数据。

对于每组数据，第一行两个正整数n,m，含义见题面；

接下来一个n行m列的整数矩阵aij。

1≤n,m≤500,1≤T≤5,aij∈{-1,[0,100]}

输出描述
对于每组数据，输出一行一个正整数，表示满足条件的最大值。如果该矩阵全为-1，则输出0.


样例输入
1
4 4
3 0 5 6
0 9 -1 4
-1 8 1 1
4 -1 5 -1
样例输出
12

提示
选择左上角的2x2正方形，和为3+0+0+9=12。
 */