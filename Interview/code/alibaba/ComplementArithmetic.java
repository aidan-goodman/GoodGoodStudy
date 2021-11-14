package alibaba;

/* 测试样例
2
00000000000000000000000000000101 11111111111111111111111111111111
00000000000000000000000000011111 00000000000000000000000000000111
*/

import java.util.Scanner;

/**
 * @author Aidan
 * @createTime 2021/10/8 20:06
 * @GitHub github.com/huaxin0304
 * @Blog aidanblog.top
 */

public class ComplementArithmetic {

    /**
     * 尽量不要在代码中出现 magic number
     * 可以使用 int 型定义为 48,49
     */
    static final char ZERO = '0';
    static final char ONE = '1';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            scanner.nextLine();
            String a = scanner.next();
            String b = scanner.next();
            // 数据读取后进行处理，转换为 10 进制
            int x = hand(a), y = hand(b);
            System.out.println(x + y);
        }
    }

    public static int hand(String str) {
        char[] chars = str.toCharArray();
        int m;

        // 符号位为 0 是一个正数，直接进行进制转换
        if (chars[0] == ZERO) {
            m = Integer.parseInt(str, 2);
        } else {
            // 将数值位按位取反
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == ONE) {
                    chars[i] = ZERO;
                } else {
                    chars[i] = ONE;
                }
            }
            String newA = String.copyValueOf(chars, 1, 31);
            // 处理末尾与符号
            m = Integer.parseInt(newA, 2) + 1;
            if (m > 0) {
                m *= -1;
            }
        }
        return m;
    }
}
