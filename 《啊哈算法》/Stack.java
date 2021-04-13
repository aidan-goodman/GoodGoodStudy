package 啊哈算法.stack_queue_list;

import java.util.Scanner;

public class Stack {
    public static void main(String[] args) {
        Scanner Input=new Scanner(System.in);
        int n=Input.nextInt();
        int[] a=new int[n];
        int[] s=new int[n];
        for (int i = 0; i <a.length ; i++) {
            a[i]=Input.nextInt();
        }
        int mid=a.length/2,top=0;//获取中间下标,int型自动取整
        for (int i = 0; i < mid; i++) {
            s[++top]=a[i];//将回文点前边的值入栈
        }

        for (int i = mid; i < a.length; i++) {
            if(a[i]==s[top])//将回文点后边的值与栈中的值反向比对
                top--;
        }
        if(top==0)
            System.out.println("嗯嗯");
        else
            System.out.println("no");
    }
}
