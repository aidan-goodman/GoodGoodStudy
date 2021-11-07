package beiye;

/**
 * Created by Aidan on 2021/10/26 14:13
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class TarString {
    public static void main(String[] args) {
        System.out.println(tarStr("aabcccddddeee"));
        System.out.println(tarXStr("2ab3c4d3e"));
    }

    // 压缩方法
    public static String tarStr(String str) {
        StringBuilder builder = new StringBuilder();
        char start = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char next = str.charAt(i);
            // 重复字符累加
            if (start == next) {
                count++;
                continue;
            }
            // 根据重复次数压缩
            if (count == 1) {
                builder.append(start);
            } else {
                builder.append(count).append(start);
            }
            // 开始下一轮重复
            start = next;
            count = 1;
        }
        // 处理末尾数据
        if (count == 1) {
            builder.append(start);
        } else {
            builder.append(count).append(start);
        }
        return builder.toString();
    }

    // 解压方法
    public static String tarXStr(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); ) {
            char c = str.charAt(i);
            // 如果当前遍历到的字符是数字，考虑位数超过一的情况
            if (Character.isDigit(c)) {
                int j = i + 1;
                for (; j < str.length(); j++) {
                    if (!Character.isDigit(str.charAt(j))) {
                        break;
                    }
                }
                // 根据数字进行重复
                int num = Integer.parseInt(str.substring(i, j));
                builder.append(String.valueOf(str.charAt(j)).repeat(Math.max(0, num)));
                i = j + 1;
                // 遇到单个字符的情况
            } else {
                builder.append(str.charAt(i));
                i++;
            }
        }
        return builder.toString();
    }
}
