package designpattern;

public class TemplateTest {
    public static void main(String[] args) {
        SubTemplate subtemplate = new SubTemplate();
        subtemplate.spendTime();
    }
}


abstract class Template {//创建抽象模板

    public void spendTime() {
        long start = System.currentTimeMillis();
        codeBlock();
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    public abstract void codeBlock();
}

class SubTemplate extends Template {//使用模板的子类

    @Override
    public void codeBlock() {
        for (int i = 0; i < 1000000; i++) {
            System.out.print("");
        }
    }
}