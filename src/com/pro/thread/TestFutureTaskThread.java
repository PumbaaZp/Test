package com.pro.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description TODO
 * @Author zhangpeng
 * @Date 2019/1/22 16:38
 **/
public class TestFutureTaskThread {

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        FutureTask<Integer> result1 = new FutureTask<>(thread);
        new Thread(result1).start();
        FutureTask<Integer> result2 = new FutureTask<>(thread);
        new Thread(result2).start();
        FutureTask<Integer> result3 = new FutureTask<>(thread);
        new Thread(result3).start();

        Integer sum;
        try {
            sum = result1.get();
            sum = result2.get();
            sum = result3.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("主线程被执行");
    }

}
class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        Thread.sleep(10000);
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        System.out.println("子线程被执行");
        return sum;
    }
}
