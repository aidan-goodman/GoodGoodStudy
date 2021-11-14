package duxiaoman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Aidan on 2021/9/26 16:29
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class JosephRing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();
        // 使用集合维护元素，方便淘汰的处理
        List<Integer> person = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            person.add(i);
        }

        int k = 0, now = a;
        while (person.size() != 1) {
            k += now;
            // 根据淘汰值找出被淘汰的具体人
            k = k % person.size() - 1;
            if (k < 0) {
                person.remove(person.size() - 1);
                k = 0;
            } else {
                person.remove(k);
            }
            // 每次更换淘汰值
            now = now == a ? b : a;
        }

        System.out.println(person.get(0));
    }
}
