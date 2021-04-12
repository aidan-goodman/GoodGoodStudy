package 算法入门;

import java.util.Scanner;

public class 分糖果 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int flag = 0;                  //判断数组是否全部相等
        int count = 0;                  //计时器
        while (flag == 0) {
            flag = 1;
            for (int i = 0; i < n; i++)      //数组全部除2
            {
                arr[i] = arr[i] / 2;
            }
            int t = arr[0];             //把数组第一项存起来，不然第一项会变
            for (int i = 0; i < n; i++)      //让小朋友把橘子给旁边的人
            {
                if (i + 1 < n)
                    arr[i] = arr[i] + arr[i + 1];
                if (i == n - 1) {
                    arr[i] = arr[i] + t;
                }
            }
            for (int i = 0; i < n; i++)       //判断，如果橘子是奇数，就加1，count拿来记数
            {
                if (arr[i] % 2 != 0) {
                    arr[i] += 1;
                    count++;
                }
            }
            for (int i = 0; i + 1 < n; i++)     //判断数组是否全部相等，如果有不等的，就把flag置为0
            {//i+1<N防止if判断时越界出错
                if (arr[i] != arr[i + 1]) {
                    flag = 0;
                }
            }
            if (flag == 1)            //flag此时还为1的话，那么表示数组就全部相等了，就输出计数器
            {
                System.out.println(count);
            }
        }
    }
}