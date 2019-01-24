package com.pro.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description TODO
 * @Author zhangpeng
 * @Date 2019/1/22 15:45
 **/
public class TestCyclicBarrierThread {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for (int i = 0; i < 4; i++) {
            Thread childThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("子线程被执行");
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }

                }
            });
            childThread.start();
        }
        cyclicBarrier.await();
        System.out.println("主线程被执行");
    }
}
