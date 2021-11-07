package meituan;

import java.util.Scanner;

/**
 * Created by Aidan on 2021/10/17 11:19
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

/* 未完成 */
// 2
//3 2
//[1, 2] [1, 3]
//4 3
//[1, 2] [2, 3] [1, 3]

// https://www.cnblogs.com/lightwindy/p/8636516.html
// https://www.cnblogs.com/uneila/p/13926794.html
    
public class Tree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int group = scanner.nextInt();
        for (int i = 0; i < group; i++) {
            int n = scanner.nextInt(), m = scanner.nextInt();
            int[][] edges = new int[m][2];
            int j = 0;
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNext()) {
                String str = scanner.next();
                if (str.lastIndexOf(']') != str.length() - 1) {
                    stringBuilder.append(str);
                    continue;
                }
                stringBuilder.append(str);
                str = stringBuilder.toString();
                stringBuilder.delete(0, stringBuilder.length());
                int dou = 0;
                char[] chars = str.toCharArray();
                for (int i1 = 0; i1 < chars.length; i1++) {
                    if (chars[i1] == ',') {
                        dou = i1;
                    }
                }
                edges[j][0] = Integer.parseInt(str.substring(1, dou));
                edges[j][1] = Integer.parseInt(str.substring(dou + 1, str.length() - 1));
            }

        }

    }
}
