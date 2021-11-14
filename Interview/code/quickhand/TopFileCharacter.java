package quickhand;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Aidan on 2021/10/7 20:22
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class TopFileCharacter {
    public static void main(String[] args) throws IOException {
        Map<Character, Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\xiao\\Downloads\\test.txt"));
        int x;
        while ((x = br.read()) > 0) {
            Character key = (char) x;
            if (map.containsKey(key)) {
                int count = map.get(key);
                map.remove(key);
                map.put(key, ++count);
            } else {
                map.put(key, 1);
            }
        }

        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());

        entries.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (int i = 0; i < 5; i++) {
            System.out.println(entries.get(i).getKey() + ":" + entries.get(i).getValue());
        }

    }
}
