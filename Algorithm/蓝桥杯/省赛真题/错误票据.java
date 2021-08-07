package 算法入门;

import java.util.Arrays;
import java.util.Scanner;

public class 错误票据 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();//会读取回车
        int[] arr = new int[10000];
        int count = 0;//计数器
        int interrupt = 0;//中断数
        int repeat = 0;//重复数
        for (int i = 0; i < N; i++) {//读取N行
            Scanner in = new Scanner(sc.nextLine());//回车结束*****很重要记住
            while (in.hasNext())
                arr[count++] = in.nextInt();
        }
        Arrays.sort(arr, 0, count);//排序
        //判断中断
        for (int i = 0; i < count - 1; i++) {
            if (arr[i] + 1 != arr[i + 1] && arr[i] != arr[i + 1]) {//两数既不连续也不重复
                interrupt = arr[i] + 1;
                break;
            }
        }
        //判断重复
        for (int i = 0; i < count - 1; i++) {
            if (arr[i] == arr[i + 1]) {//两数相等
                repeat = arr[i];
                break;
            }
        }
        System.out.println(interrupt + " " + repeat);
    }
}
