package Collection;

import org.testng.annotations.Test;

import java.util.*;

public class MapTest {
    @Test
    public void MapTest1() {
        Map<String, Integer> map = new HashMap<>();
        map.put("AA", 123);
        map.put("DD", 12345);
        map.put("ssf", 5457);
        //方式一
        Set<String> keySet = map.keySet();
        Collection<Integer> values = map.values();
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (String string :
                keySet) {
            System.out.println(string);
        }
        for (Map.Entry<String, Integer> entry :
                entrySet) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        //方式二
        Set<String> key2Set = map.keySet();
        Iterator iterator = key2Set.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            Object value = map.get(key);
            System.out.println(key + "---" + value);
        }
    }
}
