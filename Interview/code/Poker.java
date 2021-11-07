package meituan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Aidan on 2021/10/17 10:31
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class Poker {
    static List<List<Integer>> listList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1) {
            System.out.println(0);

        } else {
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i + 1;
            }
            perMun(arr, 0);

            listList.sort((o1, o2) -> {
                int i = 0;
                while ((o1.get(i).compareTo(o2.get(i)) == 0)) {
                    i++;
                }
                return o1.get(i).compareTo(o2.get(i));

            });

            System.out.println(listList.size());
            for (List<Integer> list : listList) {
                for (int i = 0; i < list.size() - 1; i++) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println(list.get(list.size() - 1));
            }
        }

    }

    public static void perMun(Integer[] arr, int i) {
        if (arr == null || arr.length == 0 || i < 0 || i > arr.length) {
            return;
        }
        if (i == arr.length - 1) {
            List<Integer> nowList = Arrays.asList(arr.clone());
            if (isTrue(nowList, nowList.size())) {
                listList.add(nowList);
            }
        } else {
            for (int j = i; j < arr.length; j++) {
                if (isTrue(Arrays.asList(arr.clone()), i)) {
                    Integer temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    perMun(arr, i + 1);
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public static boolean isTrue(List<Integer> integers, int len) {
        boolean flag = true;
        for (int i = 0; i < len; i++) {
            if (i + 1 == (integers.get(i))) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
