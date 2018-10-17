package com.pro.sort;

/**
 * @Description 快速排序
 * @Author zhangpeng
 * @Date 2018/10/17 18:28
 **/
public class QuickSort {

    public static void sort(int[] arr, int low, int high) {
        int start = low;
        int end = high;
        int key = arr[low];
        while (end > start) {
            while (end > start && arr[end] >= key)
                end--;
            if (arr[end] <= key) {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            while (end > start && arr[start] <= key)
                start++;
            if (arr[start] >= key) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
        if (start > low) sort(arr, low, start - 1);
        if (end < high) sort(arr, end + 1, high);
    }
}
