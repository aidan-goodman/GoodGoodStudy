package common;

public class EnumTest {
    public static void main(String[] args) {
        Week MONDAY = Week.MONDAY;//实例化对象常量
        System.out.println(MONDAY.getWeekName());
    }
}

enum Week implements info {
    //1.直接创建枚举类的对象，将属性写在括号中，在花括号中可以重写继承的接口的方法
    MONDAY("星期一", "忙碌的一天") {
        @Override
        public void show() {
            System.out.println("周一");
        }
    },//枚举对象用逗号隔开
    Friday("星期五", "舒服的一天") {
        @Override
        public void show() {
            System.out.println("周二");
        }
    };

    //2.声明枚举类属性
    String weekName, weekDesc;

    //3.定义构造器（私有）
    Week(String weekName, String weekDesc) {
        this.weekName = weekName;
        this.weekDesc = weekDesc;
    }

    //4.公共方法处理其他诉求
    public String getWeekName() {
        return this.weekName;
    }
}

interface info {
    void show();
}