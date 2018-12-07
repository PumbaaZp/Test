package com.pro.thread;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description 测试线程池
 * @Author zhangpeng
 * @Date 2018/12/7 16:14
 **/
public class TestExecutors {
    private List<String> onlineThread = Lists.newArrayList();

    public static void main(String[] args) throws InterruptedException {
        TestExecutors testExecutors = new TestExecutors();
        testExecutors.startThreadPoll();
    }

    public void startThreadPoll() throws InterruptedException {
        int size = 20;
        ExecutorService executorService = Executors.newFixedThreadPool(size);
        for(int i=0;i<size;i++){
            executorService.execute(new ValidateThread(i));
        }
        executorService.shutdown();
        while (true){
            if(executorService.isTerminated()){
                System.out.println("Threads end;");
                break;
            }else{
                System.out.println("Threads contains " + onlineThread.size() + " thread");
                Thread.sleep(200);
            }
        }
    }

    class ValidateThread extends Thread{

        private int num;

        ValidateThread(int num){
            this.num = num;
        }

        public void run(){
            onlineThread.add(String.valueOf(num));
            if(num % 5 == 0){
                System.out.println(num / 0);
            }else{
                System.out.println(num);
            }
            onlineThread.remove(String.valueOf(num));
        }
    }
}