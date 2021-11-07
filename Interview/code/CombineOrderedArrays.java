package quickhand;

import java.util.Arrays;

/**
 * Created by Aidan on 2021/10/8 15:32
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class CombineOrderedArrays {
    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 5, 0, 0, 0};
        int[] arr2 = new int[]{1, 4, 8};
        merge(arr1, 3, arr2, 3);
        System.out.println(Arrays.toString(arr1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }

        System.arraycopy(sorted, 0, nums1, 0, m + n);

    }
}
