package 啊哈算法.shortest;

import java.util.Scanner;

public class Dijkstra {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] arr = new int[10][10];
        int[] dis = new int[10];
        int[] book = new int[10];
        int inf = 99999999;
        int n = input.nextInt();
        int m = input.nextInt();
        int min, u = 0, v;
        for (int i = 1; i <= n; i++) {//预定义数组
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    arr[i][j] = 0;
                else
                    arr[i][j] = inf;
            }
        }
        for (int i = 1; i <= m; i++) {//输入边关系
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();
            arr[a][b] = c;
        }
        for (int i = 1; i <= n; i++) {//估值从1到各点的距离
            dis[i] = arr[1][i];
        }
        for (int i = 1; i <= n; i++) {//初始化book
            book[i] = 0;
        }
        book[1] = 1;
        //Dijkstra核心算法
        for (int i = 1; i <= n - 1; i++) {//最后的顶点无需查找
            min = inf;
            for (int j = 1; j <= n; j++) {//查找距离1最近的点
                if (book[j] == 0 && dis[j] < min) {
                    min = dis[j];
                    u = j;
                }
            }
            book[u] = 1;//将最近点的估值确定
            for (v = 1; v <= n; v++) {//从点u作中转值去查找有关系的点
                if(arr[u][v]<inf) {
                    if (dis[v] > dis[u] + arr[u][v])//如果中转值小于原值更新
                        dis[v] = dis[u] + arr[u][v];
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(dis[i]+" ");
        }
    }
}
