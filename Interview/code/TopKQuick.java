package quickhand;

import java.util.Arrays;

/**
 * Created by Aidan on 2021/10/8 14:33
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class TopKQuick {
    public static void main(String[] args) {
        int[] ans = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        int k = 3;
        topK(ans, 0, 7, k);
        System.out.println(Arrays.toString(Arrays.copyOfRange(ans, 0, k)));
    }

    public static void topK(int[] arr, int begin, int end, int k) {
        if (begin < end) {
            int pointKey = quickSort(arr, begin, end);
            if (pointKey == k - 1) {
                return;
            }
            topK(arr, begin, pointKey - 1, k);
            topK(arr, pointKey + 1, end, k);
        }
    }

    public static int quickSort(int[] arr, int begin, int end) {
        int i = begin, j = end, flagKey = arr[begin];
        while (i < j) {
            while (i < j && flagKey >= arr[j]) {
                j--;
            }
            while (i < j && flagKey <= arr[i]) {
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

        return i;
    }
}
