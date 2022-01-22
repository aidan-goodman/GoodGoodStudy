package thread;

/**
 * 首先创建子类实现Runnable或Callable接口
 * 创建一个指定线程数量的线程池
 * 使用相应方法传入对象参数连接线程
 * 关闭线程池
 * 好处：提升速度（无需创建）、降低资源消耗（可重复使用线程）、统一管理
 */

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    public static void main(String[] args) {
        //创建一个指定线程数量的线程池
//        ExecutorService service = Executors.newFixedThreadPool(10);
//        System.out.println(service.getClass());
        ThreadPoolExecutor service = (ThreadPoolExecutor)
                Executors.newFixedThreadPool(10);

        service.execute(new NumRun());//使用execute执行实现Runnable接口对象的操作
        service.submit(new NumCall());//submit执行Callable接口的对象

        service.shutdown();//关闭连接池
    }
}

class NumCall implements Callable {
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i < 100; i++) {
            if (i % 2 != 0) {
                sum += i;
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
        return sum;
    }
}

class NumRun implements Runnable {
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