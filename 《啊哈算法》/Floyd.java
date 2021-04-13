package 啊哈算法.shortest;

import java.util.Scanner;

public class Floyd {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] arr=new int[10][10];
        int inf=99999999;
        int n=input.nextInt();
        int m=input.nextInt();
        for (int i = 1; i <= n; i++) {//预定义数组
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    arr[i][j] = 0;
                else
                    arr[i][j] = inf;
            }
        }
        for (int i = 1; i <= m; i++) {//输入点之间的关系
            int a=input.nextInt();
            int b=input.nextInt();
            int c=input.nextInt();
            arr[a][b]=c;
        }
        //核心代码 ↓
        for (int k = 1; k <= n; k++) {//将1-6（K）依次作为中转点
            for (int i = 1; i <= n; i++) {//i为起点
                for (int j = 1; j <= n; j++) {//j为目标点
                    if(arr[i][j]>arr[i][k]+arr[k][j])//判断长度并更新
                        arr[i][j]=arr[i][k]+arr[k][j];
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                    System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
