package com.pro.thread;

import java.util.concurrent.*;

/**
 * @Description TODO
 * @Author zhangpeng
 * @Date 2019/1/22 17:26
 **/
public class TestCallBackAndFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> future1 = executor.submit(task);
        Future<Integer> future2 = executor.submit(task);
        Integer result1 = future1.get();
        Integer result2 = future2.get();
        System.out.println("主线程被执行");
        executor.shutdown();

    }
}

class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程被执行");
        return 0;
    }
}