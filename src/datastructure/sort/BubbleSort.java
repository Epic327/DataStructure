package com.datastructure.sort;

import java.util.Arrays;

/**
 * @author Epic
 * @create 2021-03-11 20:26
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,2,-1,0,23,99};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        int temp = 0;
        boolean flag = true;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]){
                    flag = false;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if (flag){
                break;
            }else {
                flag = true;//重置flag
            }

        }


    }

}
