package threesixzero;

import java.util.*;

/**
 * Created by Aidan on 2021/10/24 15:42
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class AmIsAre {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int zCount = scanner.nextInt(), wCount = scanner.nextInt(), bCount = scanner.nextInt();
        Map<String, Integer> map = new HashMap<>();
        for (int j = 0; j < zCount; j++) {
            String temp = scanner.next();
            map.put(temp, 0);
        }
        scanner.nextLine();
        for (int j = 0; j < wCount; j++) {
            String temp = scanner.next();
            map.put(temp, 1);
        }
        scanner.nextLine();
        for (int j = 0; j < bCount; j++) {
            String temp = scanner.next();
            map.put(temp, 2);
        }
        scanner.nextLine();

        int count = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < count; i++) {
            String str = scanner.nextLine();
            String[] strings = str.split(" ");
            List<Integer> list = new ArrayList<>();
            for (String string : strings) {
                list.add(map.get(string));
            }
            String flag = "YES";
            if (!list.contains(0)) {
                flag = "NO";
            } else {
                int WCount = 0;
                for (int i1 = 1; i1 < list.size(); i1++) {
                    if (list.get(i1 - 1) > list.get(i1) || WCount > 1 || (list.get(i1) == 2) && WCount == 0) {
                        flag = "NO";
                        break;
                    } else if (list.get(i1) == 1) {
                        WCount++;
                    }
                }
            }
            System.out.println(flag);
        }
    }
}
/*
 小A的英语考了个不及格，老师很生气，并且发现他英语的语法几乎全错！于是老师决定好好教教他英语语法。

   老师想先从句子结构开始教他。一个句子至少需要包含主谓结构，即主语和谓语，并且主语在前，谓语在后。有些句子会在谓语后面加上宾语。避免复杂，本题中句子的顺序严格按照主语-谓语-宾语的顺序（即无宾语前置和倒装等情况）。

   老师给了小A三张单词表，分别是主语单词表、谓语单词表和宾语单词表。老师要让小A用这些单词表中的单词来造句，并且规定：谓语有且仅有一个单词，主语和宾语可以包含任意个单词（主语不可为空）。老师暂时不想让小A造出能保证意思通顺的句子，他只想让小A能够学会基本的句子结构就行。

   现在，小A根据这些单词造了m条句子，现在假设你是老师，你需要判断每条句子是否符合上述句子结构。



输入描述
  第一行三个正整数n1,n2,n3，分别表示主语、谓语、宾语单词表的单词数；

  第二行包含n1个单词，单词仅由小写英文字母组成，每两个单词之间有一个空格，单词长度不超过10；

  第三行包含n2个单词，其他格式同上；

  第四行包含n3个单词，其他格式同上；

  第五行一个正整数m；

  接下来m行，每行一个句子。句子由若干单词（至少一个）组成，并且保证出现的单词都在上面的单词表内。每两个单词之间一个空格隔开。

  数据保证一个单词最多只可做一种句子成分。即每个单词仅会出现在一个单词表上。

  1≤n1,n2,n3≤1000,1≤m≤20,1≤句子单词数≤10

输出描述
对于每条句子，如果其符合句子结构，输出一行“YES”（不含引号），否则输出一行“NO”（不含引号）。


样例输入
3 3 3
i you he
am is are
yours his hers
5
i am yours
you is his
he are hers yours
i am am yours
is his
样例输出
YES
YES
YES
NO
NO
 */