package common;

import org.testng.annotations.Test;

public class StringTest {

    /**
     * String使用final定义
     * 实现了Serializable接口，支持序列化
     * 实现了Comparable接口，可以比较大小
     * 内部使用final char[]，不可变的字符数组
     */

    @Test
    public void test1() {
        String str1 = "abc";//实际是对象，但可以使用字面量的方式初始化
        String str2 = "hello";
        str2=str2.replace('e', 'd');
        System.out.println(str2);

    }

    /**
     * 字面量定义和new对象定义的区别
     */

    @Test
    public void test2(){

    }
}
