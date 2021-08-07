package 算法入门;

import java.util.Random;
import java.util.Scanner;

public class 数组重复数 {
    public static void main(String[] args) {
        int N=11;
        int[] arr=new int[N];
        for (int i = 0; i <arr.length-1 ; i++) {
            arr[i]=i+1;
        }//给数组赋值，最后一位留空赋予随机数
        arr[arr.length-1]=new Random().nextInt(N-1)+1;//生成N以内的随机数
        int index=new Random().nextInt(N);//生成一个随机下标
        //将随机下标与随机数的位置进行调换
        int temp;
        temp=arr[index];
        arr[index]=arr[arr.length-1];
        arr[arr.length-1]=temp;

        for(int j:arr){
            System.out.print(j+" ");
        }
        System.out.println();

        int x1=0;
        for (int i = 0; i < N; i++) {
            x1=x1^i^arr[i];
        }
        System.out.println(x1);
    }

    public static class 蛇形矩阵 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int one = 1, margin = 1;//每列的第一个数和列差
            for (int i = n; i > 0; i--) {
                int first = one, mar = margin + 1;//行差比列差大一
                for (int j = 1; j <= i; j++) {
                    System.out.print(first + " ");
                    first += mar;
                    mar++;
                }
                System.out.println();
                one += margin;
                margin++;
            }
        }
    }
}
