package Collection;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionTest {
    public static void main(String[] args) {
        Collection<Object> collection = new ArrayList<>();
        collection.add(123);
        collection.add("text");
        System.out.println(collection.contains(123));
        //.contains()判断包含使用.equals()，自定义对象则应该重写.equals()
        System.out.println(collection.contains(new String("text")));

        Collection<Integer> coll = Arrays.asList(123, 456, 789);
        System.out.println(coll.contains(123));
        //移除collection中在coll中出现的元素（差集，删除公共元素）
        collection.removeAll(coll);
        //移除不在coll中的元素（并集，只保留公共元素）
        collection.retainAll(coll);

        Object obj = collection.toArray();//集合转换为数组
        List<String> list = Arrays.asList(new String[]{"AA", "BB"});//数组转换为集合
    }

    @Test
    public void iteratorTest() {//迭代器遍历（为Collection接口使用）
        List<String> stringList = new ArrayList<>();
        stringList.add("AA");
        stringList.add("CC");
        stringList.add("dd");

/*        迭代器正常使用
        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        迭代器可以使用.remove()进行指针跳过，调用之前要指向新对象（跟.next()成对使用）*/

        for (String s : stringList) {//foreach迭代器方式，1.5新增
            System.out.println(s);
        }

    }

}
