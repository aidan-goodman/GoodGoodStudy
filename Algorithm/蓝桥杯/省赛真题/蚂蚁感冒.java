package 算法入门;

import java.util.Scanner;

public class 蚂蚁感冒 {
    public static int absolute(int k) {
        if (k < 0)
            return -k;
        return k;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//蚂蚁的个数
        int a = sc.nextInt();//第一只蚂蚁（感冒）
        int sum = 1, c = 0;
        boolean flag = false;//判断是否感冒
        for (int i = 1; i < n; i++) {
            int b = sc.nextInt();
            //第一种情况：
            if (a > 0) { //首只蚂蚁向右
                if (absolute(b) > a && b < 0) {  //右边所有向左蚂蚁都感冒,有蚂蚁感冒则d变为true
                    flag = true;
                    sum++; //sum:感冒蚂蚁个数
                }
                if (absolute(b) < a && b > 0) {  //当右边向左的蚂蚁有感冒(flag=true)时，则左边所有
                    c++;  //c:左边向右蚂蚁个数    向右蚂蚁都感冒,c最后加入sum中；否则都不感冒，c就不用了
                }
            }

            //第二种情况：
            if (a < 0) {  //首只蚂蚁向左
                if (absolute(b) < -a && b > 0) {  //左边所有向右蚂蚁都感冒,有蚂蚁感冒则d变为true
                    flag = true;
                    sum++;
                }
                if (absolute(b) > -a && b < 0) {  //当左边向右的蚂蚁有感冒(flag=true)时，则右边所有向左蚂蚁都感冒,c最后
                    c++;          //加入sum中；否则都不感冒，c就不用了
                }
            }
        }
        sum = (flag = true) ? sum + c : sum; //当flag=true时，加上c
        System.out.println(sum);
        sc.close();
    }
}