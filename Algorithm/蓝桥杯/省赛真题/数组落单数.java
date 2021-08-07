package 算法入门;

import java.util.Random;

public class 数组落单数 {
    public static void main(String[] args) {
        int N = 11;
        int[] arr = new int[N];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i]=arr[i+1] = i + 1;
            i++;
        }//给数组赋值，最后一位留空赋予随机数
        arr[arr.length - 1] = new Random().nextInt(N - 1) + 1;//生成N以内的随机数
        int index = new Random().nextInt(N);//生成一个随机下标
        //将随机下标与随机数的位置进行调换
        int temp;
        temp = arr[index];
        arr[index] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;

        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
        int x=0;
        for (int i = 0; i < N; i++) {
            x=x^arr[i];
        }
        System.out.println(x);
    }
}
