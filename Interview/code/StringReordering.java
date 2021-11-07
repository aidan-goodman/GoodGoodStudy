package quna;

import java.util.*;

// 对字符串按照字符出现频率重新排序，频率相同按大小写排序，同为大写或小写按字母序排列

public class StringReordering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : chars) {
            int count;
            if (map.containsKey(c)) {
                count = map.get(c);
                map.put(c, ++count);
            } else {
                map.put(c, 1);
            }
        }

        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());

        entryList.sort((o1, o2) -> {
            if (!Objects.equals(o2.getValue(), o1.getValue())) {
                return o2.getValue() - o1.getValue();
            } else if ((o1.getKey() > 94 && o2.getKey() > 94) || (o1.getKey() < 95 && o2.getKey() < 95)) {
                return o1.getKey() - o2.getKey();
            }
            return o1.getKey() > 94 ? 1 : -1;
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entryList) {
            stringBuilder.append(String.valueOf(entry.getKey()).repeat(Math.max(0, entry.getValue())));
        }
        System.out.println(stringBuilder);

    }
}
