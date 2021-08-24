package thread;

/**
 * 创建子类实现Callable接口
 * 重写call()方法
 * 实例化对象，作为参数传入FutureTask构造器中
 * 将FutureTask对象作为参数放入Thread构造器中
 * 可以使用FutureTask对象.get()获取call()的返回值
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();
        FutureTask futureTask = new FutureTask(numThread);

        new Thread(futureTask).start();

        try {
            Integer sum = (Integer) futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class NumThread implements Callable {
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i < 100; i++) {
            if (i % 2 == 0) {
                sum += i;
                System.out.println(i);
            }
        }
        return sum;
    }
}