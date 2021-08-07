package 啊哈算法.sort;

import java.util.Scanner;

public class 桶排序 {
    public static void main(String[] args) {
        Scanner Input=new Scanner(System.in);
        int[] a=new int[10];
        for (int i = 0; i < 10; i++) {
            a[i]=0;
        }
        for (int i = 0; i < 5; i++) {
            int t=Input.nextInt();//输入5个数（数组范围0~9之间）
            a[t]++;//对应下标加1
        }
        for (int i = 0; i < 10; i++) {//遍历数组
            for (int j = 0; j < a[i]; j++) {//输出小于数组内容个数下与之对应的下标
                System.out.print(i+" ");
            }
        }
    }
}
