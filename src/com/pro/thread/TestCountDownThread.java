package com.pro.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Description TODO
 * @Author zhangpeng
 * @Date 2019/1/22 15:24
 **/
public class TestCountDownThread {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            Thread childThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("子线程被执行");
                    latch.countDown();
                }
            });
            childThread.start();
        }
        latch.await();
        System.out.println("主线程被执行");
    }
}
