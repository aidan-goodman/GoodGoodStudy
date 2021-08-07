package 啊哈算法.tu;

import java.util.Scanner;

public class 图的遍历_dfs {
    static int sum=0;//记录走过的点数
    static int n;
    static int[][] arr=new int[10][10];//二维数组记录图与关系
    static int[] book=new int[10];
    static void dfs(int cur){//dfs方法，cur当前点
        System.out.print(cur+" ");//打印点
        sum++;
        if (sum==n)//所有点遍历完，结束
            return;
        for (int i = 1; i < n; i++) {
            if (arr[cur][i]==1&&book[i]==0){
                book[i]=1;
                dfs(i);//递归搜索
            }
        }
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        n=input.nextInt();
        for (int i = 1; i <= n; i++) {//预定义数组
            for (int j = 1; j <= n; j++) {
                if (i==j)
                    arr[i][j]=0;
                else
                    arr[i][j]=99999;
            }
        }
        int m=input.nextInt();
        for (int i = 1; i <= m; i++) {//输入连线关系
            int a=input.nextInt();
            int b=input.nextInt();
            arr[a][b]=1;arr[b][a]=1;
        }
        book[1]=1;
        dfs(1);
        //输出少最后一位，回头用c写一遍试试
   }
}
