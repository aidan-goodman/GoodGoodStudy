package quickhand;

import org.junit.jupiter.api.Test;

/**
 * Created by Aidan on 2021/10/8 19:01
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class DelCharGetPalindrome {
    @Test
    void test() {
        System.out.println(validPalindrome("abcbca"));
    }

    public boolean validPalindrome(String s) {
        for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
            // 如果不相等，删除左边或右边的元素
            if (s.charAt(left) != s.charAt(right))
                return isPalindrome(s, left + 1, right) ||
                        isPalindrome(s, left, right - 1);
        }
        return true;
    }

    // 判断字符串 s 的 [left, right] 是否回文
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }
}
