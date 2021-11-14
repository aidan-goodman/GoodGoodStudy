package duxiaoman;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by Aidan on 2021/9/26 16:31
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class TimeLag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int total = m + n;
        scanner.nextLine();
        Map<LocalTime, LocalTime> map = new TreeMap<>();
        // 定义字符串转时间的格式（直接用字符串也行）
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        // 依次转换格式放入 map 中
        while (total > 0) {
            String time = scanner.nextLine();
            LocalTime start = LocalTime.parse(time.substring(0, 5), dtf);
            LocalTime end = LocalTime.parse(time.substring(6), dtf);
            if (map.get(end) == null) {
                map.put(end, start);
            } else if (start.isAfter(map.get(end))) {// 结束时间相同只保留开始时间晚的
                map.put(end, start);
            }
            total--;
        }
        scanner.close();
        int count = 0;
        LocalTime perEnd = LocalTime.parse("00:00", dtf);
        for (Map.Entry<LocalTime, LocalTime> entry : map.entrySet()) {
            if (count == 0) {// 第一场永远是最优解
                perEnd = entry.getKey();
                count++;
                continue;
            }
            // 开始时间不早于上一场的结束时间即有效
            if (!entry.getValue().isBefore(perEnd)) {
                count++;
            }
            perEnd = entry.getKey();
        }

        System.out.println(count);
    }
}
