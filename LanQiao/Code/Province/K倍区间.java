package 省赛真题.T2017;

import java.util.Scanner;
/*
给定一个长度为N的数列，A1, A2, ... AN，
如果其中一段连续的子序列Ai, Ai+1, ... Aj(i <= j)之和是K的倍数
我们就称这个区间[i, j]是K倍区间。

你能求出数列中总共有多少个K倍区间吗？

输入
-----
第一行包含两个整数N和K。(1 <= N, K <= 100000)
以下N行每行包含一个整数Ai。(1 <= Ai <= 100000)

输出
-----
输出一个整数，代表K倍区间的数目。


例如，
输入：
5 2
1
2
3
4
5

程序应该输出：
6
 */


public class K倍区间 {
    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int k = in.nextInt();
        int arr[] = new int[N];
        int count = 0;
        int s = 0,t = 0;
        for(int i=0;i<arr.length;i++) {
            arr[i] = in.nextInt();
        }
        for(int i=0;i<N;i++) {
            s = s +arr[i];
            if(s%k == 0) {
                count ++;
            }

        }
        //System.out.println(count);//从arr[0]往后加能够符合条件的个数
        for(int i=0;i<N;i++) {
            for(int j=i+1;j<N;j++) {
                t = t+arr[j];
                if(t%k == 0)
                    count++;
            }//分段式判断，从arr[1]开始，判断完成从arr[2]开始
            t =0;
        }
        System.out.println(count);
    }

}

