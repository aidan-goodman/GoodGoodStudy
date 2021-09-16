package test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Aidan on 2021/9/11 20:24
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class UniqueNumber {
    public static void main(String[] args) {
        int[] test = {1, 1, 4, 6, 7, 7, 3};
        int[] result = find(test);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] find(int[] arg) {
        Set<Integer> set = new LinkedHashSet<>();
        Set<Integer> delSet = new HashSet<>();
        for (int i = 0; i < arg.length; i++) {
            if (!set.contains(arg[i]) && !delSet.contains(arg[i])) {
                set.add(arg[i]);
            } else {
                set.remove(arg[i]);
                delSet.add(arg[i]);
            }
        }
        int[] arr = new int[set.size()];
        int index = 0;
        for (Integer i : set) {
            arr[index] = i;
            index++;
        }
        return arr;
    }
}
