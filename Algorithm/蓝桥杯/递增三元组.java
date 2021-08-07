package 省赛真题.T2018;

import java.util.Arrays;
import java.util.Scanner;

public class 递增三元组 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int N=input.nextInt();
        int[] a=new int[N];
        int[] b=new int[N];
        int[] c=new int[N];

        for (int i = 0; i < N; i++) {
            a[i]=input.nextInt();
        }
        for (int i = 0; i < N; i++) {
            b[i]=input.nextInt();
        }
        for (int i = 0; i < N; i++) {
            c[i]=input.nextInt();
        }

        Arrays.sort(a);//API排序（自小到大）
        Arrays.sort(b);
        Arrays.sort(c);

        int p=0,q=0;
        long ans=0;
        for (int i = 0; i < N; i++) {
            /*以下以b组做判断，a组中比b组小的的下标为p个，c组中比b组大的的下标为n-q个
            也就是说，p*（n-q）的值就是当j固定时（i,j,k）的个数
            遍历b组，将每一组符合条件的p*（n-q）加起来的总和就是所有（i,j,k）的个数
             */
            while (p<N&&a[p]<b[i])p++;
            while (q<N&&c[q]<=b[i])q++;
            ans+=1L*p*(N-q);//因为ans是一个长整型，所以在乘式前加上1L将其转换格式
        }
        System.out.println(ans);

    }
}
