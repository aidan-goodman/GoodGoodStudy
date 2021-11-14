package tuyayidong;

import java.util.Scanner;

/**
 * Created by Aidan on 2021/9/3 17:43
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class ArithmeticNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fre = scanner.nextInt();
        for (int i = 0; i < fre; i++) {

            long n = scanner.nextInt();
            long m = scanner.nextInt();

            long product = 0;
            while (n < 10) {
                n++;
                m--;
            }
            while (m-- != 0) {
                long temp = 0;
                long power = 1;
                while (n > 0) {
                    temp = n % 10;
                    temp++;
                    // 处理 10 占两位的情况
                    if (temp == 10) {
                        temp *= power;
                        power *= 10;
                    } else {
                        temp *= power;
                    }
                    product += temp;
                    power *= 10;
                    n /= 10;
                }
                temp = 0;
                power = 1;
                n = product;
            }
            long count = 0;
            while (product > 0) {
                product = product / 10;
                count++;
                count %= Math.pow(10, 9) + 7;
            }
            System.out.println(count);
        }
    }
}
