package com.pro.sort;

import java.util.Random;

/**
 * @Description 测试排序方法
 * @Author zhangpeng
 * @Date 2018/10/17 18:42
 **/
public class Test {
    private final static int ARR_SIZE = 100000;

    public static int[] generalArr(int length) {
        int[] arr = new int[ARR_SIZE];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (1 + Math.random() * ARR_SIZE);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = generalArr(ARR_SIZE);
        Long startTime = System.nanoTime();
        QuickSort.sort(arr, 0, arr.length - 1);
        long cost = System.nanoTime() - startTime;
        System.out.println("Sort cost:" + cost + " milliseconds");
    }

}
