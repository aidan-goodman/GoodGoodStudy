package 啊哈算法.sort;

import java.util.Scanner;

public class 冒泡排序 {
    public static void main(String[] args) {
        Scanner Input=new Scanner(System.in);
        int[] a=new int[5];
        for (int i = 0; i < 5; i++) {
            a[i]=Input.nextInt();
        }
        for (int i = 0; i < 4; i++) {//N个数只需要比对N-1次
            for (int j = 0; j < 4-i; j++) {//每比对i次，后i为的数都将确定，只需要比对剩下的N-1-i
                if(a[j]<a[j+1]){
                    int t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t;
                }
            }
        }
        for (int m:a){
            System.out.print(m+" ");
        }
    }
}
