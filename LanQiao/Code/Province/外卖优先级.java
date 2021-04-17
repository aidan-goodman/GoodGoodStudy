package 省赛真题.T2019;

import java.util.Arrays;
import java.util.Scanner;

public class 外卖优先级 {
    public static void main(String args[]) {

        int t = 0, w = 0;
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int[][] state = new int[c+1][a+1];
//        long start = System.currentTimeMillis();   //要测试的程序或方法 个人用来检测运行时间的。

        for(int i = 0; i <= c; i++)
            for(int j = 0; j <= a; j++)
                state[i][j] = -1;
//        for(int i = 0; i <= a; i++) state[0][i] = 0;
        Arrays.fill(state[0], 0);     //---------Java所谓的的二维数组，只有a{{},{}}，把第一行填充0，用于接下去的加
        for(int i = 0; i < b; i++) {
            t = sc.nextInt();
            w = sc.nextInt();
            if(t > c) continue;
            if(state[t][w] == -1) state[t][w] = 0;
            state[t][w] += 2;
        }


        for(int i = 1; i <= a; i++) {
            for(int j = 1; j <= c; j++) {
                state[j][i] = state[j-1][i] + state[j][i];
                if(state[j][i] < 0) state[j][i] = 0;

            }
        }
        //     -----------下面开始判断-------------
//        ArrayList<Integer> jilu = new ArrayList<Integer>();
        int sign = 0, index = 0;
        int num = 0;
        for(int i = 1; i <= a; i++) {
            sign = state[c][i];
            index = c;
            while(sign == 4 || sign == 5) {
                sign = state[--index][i];
            }
            if(sign > 5) {
                num++;
            }
        }
        System.out.println(num);

//        long end = System.currentTimeMillis();
//        System.out.println("程序运行时间："+(end-start)+"ms");

    }
}