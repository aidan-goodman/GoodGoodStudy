package thread;

/**
 * 方式二：实现Runnable接口
 * 1.创建子类实现Runnable接口
 * 2.实现类去实现Runnable中的run()方法
 * 3.实例化对象，将对象作为参数放到Thread类的构造器中创建多个Thread对象
 * 4.通过Thread对象调用start()方法
 */
public class RunnableTest {
    public static void main(String[] args) {
        //3.实例化对象，将对象作为参数放到Thread类的构造器中创建多个Thread对象
        RunThread runThread = new RunThread();
        Thread thread = new Thread(runThread);
        //4.通过Thread对象调用start()方法
        thread.start();


        Thread thread1 = new Thread(runThread);
        thread1.start();
    }
}

//1.创建子类实现Runnable接口
class RunThread implements Runnable {
    //2.实现类去实现Runnable中的run()方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
