package test;

/**
 * Created by Aidan on 2021/9/27 19:33
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class Stars {
    public static void main(String[] args) {
        int a, b, c, d, e;
        for (int i = 10000; i < 99999; i++) {
            a = i % 10;
            b = (i / 10) % 10;
            c = (i / 100) % 10;
            d = (i / 1000) % 10;
            e = i / 10000;

            if ((a * a * a * a * a + b * b * b * b * b + c * c * c * c * c + d * d * d * d * d + e * e * e * e * e) == i) {
                System.out.print(i + ",");
            }
        }
    }
}
