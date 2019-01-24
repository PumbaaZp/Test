package com.pro.thread;

/**
 * @Description 使用yield不安全
 * @Author zhangpeng
 * @Date 2019/1/22 16:03
 **/
public class TestYieldThread {

    public static void main(String[] args) {
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
                }
            });
            childThread.start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println("主线程被执行");

    }
}
