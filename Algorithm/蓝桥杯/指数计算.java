package 省赛真题.T2020;

import java.math.BigInteger;

public class 指数计算 {
    public static void main(String[] args) {
        BigInteger a=new BigInteger("7");
        BigInteger b=new BigInteger("1921");
        BigInteger c=a.pow(2020).remainder(b);
        System.out.println(c);
    }
}
