package 啊哈算法.tu;

import java.util.Scanner;

public class 最短路径_dfs {
    static int[][] arr=new int[100][100];//存储地图关系
    static int[] book=new int[100];//记录路径，免得回头
    static int n;//城市个数，这里也代表目的地
    static int min=999999;
    static void dfs(int cur,int dis){
        if (dis>min)//如果路程比min大了，那就不用走了
            return;
        if (cur==n){
            if (dis<min)//到达目的地，判断路程
                min=dis;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (arr[cur][i]!=999999&&book[i]==0){//可以走且不回头（999999代表无限大）
                book[i]=1;
                dfs(i,dis+arr[cur][i]);
                book[i]=0;//每返回一次，将节点的占有移除
            }
        }
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        n=input.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i==j)
                    arr[i][j]=0;//自己到自己
                else
                    arr[i][j]=999999;//代表无穷大
            }
        }
        int m=input.nextInt();
        for (int i = 1; i <= m; i++) {//输入公路以及之间的长度
            int a=input.nextInt();
            int b=input.nextInt();
            int c=input.nextInt();
            arr[a][b]=c;
        }
        book[1]=0;
        dfs(1,0);
        System.out.println(min);

    }
}
