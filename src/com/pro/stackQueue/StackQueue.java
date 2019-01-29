package com.pro.stackQueue;

import java.util.Stack;

/**
 * @Description 用栈实现队列
 * @Author zhangpeng
 * @Date 2019/1/29
 **/
public class StackQueue {
    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();

    public void enQueue(int element){
        stackA.push(element);
    }
    public Integer deQueue(){
        if(stackB.isEmpty()){
            if (stackA.isEmpty()) {
                return null;
            }
            transfer();
        }
        return stackB.pop();
    }

    private void transfer() {
        while (!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }
    }

    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
        stackQueue.enQueue(1);
        stackQueue.enQueue(2);
        stackQueue.enQueue(3);

        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());

        stackQueue.enQueue(4);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
    }
}
