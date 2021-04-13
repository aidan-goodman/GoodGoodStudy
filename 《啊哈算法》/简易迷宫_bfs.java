package 啊哈算法.search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class 简易迷宫_bfs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<Integer> queue=new LinkedList<>();
        int[][] arr = new int[50][50];
        int [][] book=new int[50][50];
        int n = input.nextInt();
        int m = input.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.nextInt();
            }
        }
        int tx , ty;
        int startx = input.nextInt();
        int starty = input.nextInt();
        int p = input.nextInt();
        int q = input.nextInt();

        queue.add(startx);

    }
}
