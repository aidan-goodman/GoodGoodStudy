package 算法入门;

import java.util.Scanner;
/*
从整数 n 开始，如果 n 是偶数，把它除以 2；如果 n 是奇数，把它乘 3 加1。用新得到的值重复上述步骤，直到 n = 1 时停止。
例如，n = 22 时该算法生成的序列是：
22，11，34，17，52，26，13，40，20，10，5，16，8，4，2，1
https://mp.weixin.qq.com/s/cf1BDUER9zoCjM97wTNV2Q
 */
public class 三N加一 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while (in.hasNext()){
            int i=in.nextInt(),j=in.nextInt();
            int start=i,end=j;
            if (i>j){
                start=j;
                end=i;
            }
            int max=-1;
            for (int n=start;n<=end;n++){
                int m=run(n);
                max=Integer.max(max,m);
            }
            System.out.println(i+" "+j+" "+max);
        }
    }
    public static int run(int k){
        int count=1;
        while (k!=1){
            if(k%2==0){
                k/=2;
            }else {
                k=k*3+1;
            }
            count++;
        }
        return count;
    }
}