package oop;

public class InterfaceTest {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.work(new UPan());//使用匿名内部类传入
    }
}

class Computer {
    public void work(USB usb) {//使用接口作为形参，传入实现此接口的子类
        usb.start();
        System.out.println("数据传输中");
        usb.stop();

    }
}

interface USB {
    int LENGTH = 3, WIDTH = 4, HEIGHT = 5;//定义全局常量，自动省略static final

    //定义抽象方法，自动省略abstract
    void start();

    void stop();
}

class UPan implements USB {//用类实现接口，覆盖其所有的抽象方法

    @Override
    public void start() {
        System.out.println("U盘开始运行");
    }

    @Override
    public void stop() {
        System.out.println("U盘停止运行");
    }
}
