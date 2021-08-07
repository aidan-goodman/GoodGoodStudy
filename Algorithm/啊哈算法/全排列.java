package 啊哈算法.search;

import java.util.Scanner;

public class 全排列 {
    static int n;
    static int[] a=new int[10];
    static int[] book=new int[10];
    //新建一个存储数组，一个判断数组，一个长度的全局变量
    static void dfs(int step){//全排列递归方法
        if (step==n){//如果step到了N的位置则说明一组排列已经完成，输出
            for (int i = 0; i < n; i++) {
                System.out.print(a[i]);
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (book[i]==0){//判断当前数字是否进入排序，还未进入
                a[step]=i;
                book[i]=1;//标记已经参与排序的数字
                dfs(step+1);//调用方法
                book[i]=0;//去除标记
            }
        }
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        n=input.nextInt();
        dfs(0);
    }
}