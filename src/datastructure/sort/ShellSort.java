package com.datastructure.sort;

import java.util.Arrays;

/**
 * @author Epic
 * @Description 希尔排序
 * @create 2021-03-13 20:48
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 交换法
     *
     * @param arr
     */
    public static void shellSort1(int[] arr) {
        //第一个for： 是遍历的轮数
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            int temp = 0;
            //第二个for：是遍历的组数
            for (int i = gap; i < arr.length; i++) {
                //第三个for： 每一组之间的
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        //交换
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    /**
     * 移位法
     * @param arr
     */
    public static void shellSort2(int[] arr ){
        //组数的遍历
        for (int gap = arr.length /2; gap > 0; gap /= 2){
            for (int i =  gap; i < arr.length; i++){
                //待插入索引
                int j = i;
                //待插入值
                int temp = arr[j];
                //如果索引大的值 < 索引小的值
                if (arr[j] < arr[j-gap]){
                    while (j - gap >= 0 && temp < arr[j - gap]){
                        //把索引小的值移动到索引大的值
                        arr[j] = arr[j-gap];
                        //j即待插入的索引位置
                        j -= gap;
                    }

                    //当退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }

            }
        }
    }
}
