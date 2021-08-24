package Collection;

import org.testng.annotations.Test;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeTest {
    @Test
    public void treeTest() {
        //必须添加相同类的对象
        //必须实现comparable接口或实现comparator（添加的元素必须能排序）
        //添加元素的重复性根据comparable的返回值进行决定，如果返回0就看做相等
        Set<UserTest> treeSet = new TreeSet<>();
        treeSet.add(new UserTest("AA", 12));
        treeSet.add(new UserTest("VV", 18));
        treeSet.add(new UserTest("GG", 19));
        treeSet.add(new UserTest("GG", 40));
        Iterator<UserTest> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void treeComparatorTest() {
        Comparator<UserTest> comparator = new Comparator<UserTest>() {
            @Override
            public int compare(UserTest o1, UserTest o2) {
                if (o1.getName().equals(o2.getName())) {
                    return (o1.getAge() - o2.getAge());
                } else {
                    return o1.getName().compareTo(o2.getName());
                }

            }
        };
        Set<UserTest> userTests = new TreeSet<>(comparator);
        userTests.add(new UserTest("AA", 12));
        userTests.add(new UserTest("Aidan", 21));
        userTests.add(new UserTest("Marry", 12));
        userTests.add(new UserTest("Aidan", 12));
        userTests.add(new UserTest("Marry", 12));
        for (UserTest serTest :
                userTests) {
            System.out.println(serTest);
        }
    }
}
