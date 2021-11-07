package quickhand;

import java.util.Arrays;

/**
 * Created by Aidan on 2021/10/8 13:58
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] ans = new int[]{10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        quickSort(ans, 0, ans.length - 1);
        System.out.println(Arrays.toString(ans));
    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin > end) {
            return;
        }
        int i = begin, j = end, flagKey = arr[begin];
        while (i < j) {
            while (i < j && flagKey <= arr[j]) {
                j--;
            }
            while (i < j && flagKey >= arr[i]) {
                i++;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[begin] = arr[i];
        arr[i] = flagKey;

        quickSort(arr, begin, j - 1);
        quickSort(arr, j + 1, end);
    }
}
