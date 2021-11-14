package qianxin;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Aidan on 2021/10/16 15:31
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class QueryEleInArr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] char_list = new int[]{32, 39, 45, 33, 34, 35, 36, 37, 38, 40,
                41, 42, 44, 46, 47, 58, 59, 63, 64, 91, 92, 10, 9, 93, 94, 95,
                96, 123, 124, 125, 126, 43, 60, 61, 62, 215, 247, 48, 49, 50, 51,
                52, 53, 54, 55, 56, 57, 97, 65, 98, 66, 99, 67, 100, 68, 101, 69,
                102, 70, 103, 71, 104, 72, 105, 73, 106, 74, 107, 75, 108, 76, 109,
                77, 110, 78, 111, 79, 112, 80, 113, 81, 114, 82, 115, 83, 116, 84,
                117, 85, 118, 86, 119, 87, 120, 88, 121, 89, 122, 90
        };

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < char_list.length; i++) {
            map.put(char_list[i], i + 1);
        }

        String str = scanner.nextLine();

        String[] split = str.split(",");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < split.length - 1; i++) {
            if (map.containsKey(Integer.parseInt(split[i]))) {
                stringBuilder.append(map.get(Integer.parseInt(split[i]))).append(',');
            } else {
                stringBuilder.append("0,");
            }
        }
        if (map.containsKey(Integer.parseInt(split[split.length - 1]))) {
            stringBuilder.append(map.get(Integer.parseInt(split[split.length - 1])));
        } else {
            stringBuilder.append(0);
        }

        System.out.println(stringBuilder);
    }
}
