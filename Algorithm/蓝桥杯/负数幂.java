package 省赛真题.T2018;

import java.io.FileNotFoundException;
import java.math.BigInteger;

public class 负数幂 {
    public static void main(String[] args) throws FileNotFoundException {
        BigInteger two = BigInteger.valueOf(2);//2和3不能直接用所以定义为BigInteger型
        BigInteger three = BigInteger.valueOf(3);

        BigInteger a = BigInteger.valueOf(2);
        BigInteger b = BigInteger.valueOf(3);
        BigInteger aa = null;
        BigInteger bb = null;

        for (int i = 0; i < 123455; i++) {
            aa = a.multiply(two).subtract(b.multiply(three));//a*2-(b*3)
            bb = a.multiply(three).add(b.multiply(two));//a*3+b*2

            a = aa;//将aa的值赋予a中进行下次循环
            b = bb;
        }
        //System.setOut(new PrintStream(new File("E:\\out.txt")));//输出到文本以查看
        System.out.println(aa + (bb.compareTo(BigInteger.ZERO) < 0 ? "-" : "+") + bb + "i");
        //bb.compareTo(BigInteger.ZERO) < 0 ? "-" : "+"  判断bb是否小于0，小于输出一个负号，大于输出加号
    }
}
