package 算法入门;

import java.util.Scanner;

public class 删除数组0元素 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] arr = new int[a];
        int index = 0;//记录数组中有一个为零的数
        for (int i = 0; i < a; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] == 0) {
                index++;
            }
        }
        int[] cha = new int[a - index];
        int g = 0;
        for (int i = 0; i < a; i++) {
            if (arr[i] != 0) {
                cha[g++] = arr[i];
            }
        }
        for (int i : cha) {
            System.out.print(i + " ");
        }
        System.out.println(cha.length);
    }
}
