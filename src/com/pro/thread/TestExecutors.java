package com.pro.thread;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description 测试线程池
 * @Author zhangpeng
 * @Date 2018/12/7 16:14
 **/
public class TestExecutors {
    private List<String> onlineThread = Lists.newArrayList();

    public static void main(String[] args){
        TestExecutors testExecutors = new TestExecutors();
        testExecutors.startThreadPoll();
    }

    public void startThreadPoll(){
        int size = 20;
        ExecutorService executorService = Executors.newFixedThreadPool(size);
        for(int i=0;i<size;i++){
            executorService.execute(new ValidateThread(i));
        }
        executorService.shutdown();
        try{
            if(!executorService.awaitTermination(10, TimeUnit.SECONDS)){
                System.out.println("Threads overtime exist. Still " + onlineThread.size() + " thread");
                onlineThread.clear();
                executorService.shutdownNow();
            }else{
                System.out.println("Threads complete, size: " + size);
            }
        }catch (InterruptedException e){
            System.out.println("Catch interrupt exception");
        }
        /*long statTime = System.currentTimeMillis();
        while (true){
            if(executorService.isTerminated()){
                System.out.println("Threads end;");
                break;
            }else{
                System.out.println("Threads contains " + onlineThread.size() + " thread");
                Thread.sleep(200);
            }
            if(System.currentTimeMillis() - statTime > 10 * 1000){
                System.out.println("Threads overtime exist. Still " + onlineThread.size() + " thread");
                executorService.shutdownNow();
                onlineThread.clear();
                break;
            }
        }*/
    }

    class ValidateThread extends Thread{

        private int num;

        ValidateThread(int num){
            this.num = num;
        }

        public void run(){
            onlineThread.add(String.valueOf(num));
            try {
                Thread.sleep(num * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(num % 5 == 0){
            }else{
            }
            System.out.println("Thread num: " + num + " occur");
            onlineThread.remove(String.valueOf(num));
        }
    }
}