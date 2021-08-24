package test;

public class Test {
    public static void main(String[] args) {
        Num num = new Num();

        Thread thread1 = new Thread(num);
        Thread thread2 = new Thread(num);

        thread1.setName("线程一");
        thread2.setName("线程二");

        thread1.start();
        thread2.start();
    }


}

class Num implements Runnable {
    private int number = 0;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();//2. 另一线程执行时，唤醒被阻塞的线程
                if (number < 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + (number + 1));
                    number++;

                    try {
                        wait();//1. 输出一个数之后将当前线程阻塞
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}