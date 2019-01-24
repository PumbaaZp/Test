package com.pro.thread;

import java.util.Date;
import java.util.Vector;

/**
 * @Description TODO
 * @Author zhangpeng
 * @Date 2019/1/22 14:03
 **/
public class TestJoinThread {

    public static void main(String[] args) throws InterruptedException {
        Vector<Thread> vector = new Vector<>();
        for (int i = 0; i < 5; i++) {
            Thread childThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("子线程被执行");
                }
            });
            vector.add(childThread);
            childThread.start();
        }
        for (Thread thread : vector){
            thread.join();
        }
        System.out.println("主线程被执行");
    }
}
