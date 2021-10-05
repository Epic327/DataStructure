package com.datastructure.sort;

import java.util.Arrays;

/**
 * @author Epic
 * @create 2021-03-11 20:57
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 2, -1, 0, 23, 99};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //先排第一个数，找到最小的，放在首位，与之交换
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;//先假定最小值的索引为0
            int min = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    //说明min不是最小
                    //则重置min和minIndex
                    min = arr[j];
                    minIndex = j;

                }
            }
            //遍历到最小值后，即交换位置
            //如果最小值索引不是0,将最小值放在arr[0]
            if (minIndex != i) {
                //把arr[0]放在最小值位置
                arr[minIndex] = arr[i];
                //把最小值放在arr[0]
                arr[i] = min;
            }
        }
    }
}

//        int minIndex = 0;//先假定最小值的索引为0
//        int min = arr[0];//最小值是arr[0]
//        //从第二位开始遍历比较
//        for (int i = 0 + 1 ; i <arr.length ; i++) {
//            if (min > arr[i]){
//                //说明min不是最小
//                //则重置min和minIndex
//                min = arr[i];
//                minIndex = i;
//
//            }
//        }
//        //遍历到最小值后，即交换位置
//        //如果最小值索引不是0,将最小值放在arr[0]
//        if (minIndex != 0){
//            //把arr[0]放在最小值位置
//            arr[minIndex] = arr[0];
//            //把最小值放在arr[0]
//            arr[0] = min;
//        }
//
//        //第二轮
//        int minIndex = 1; //假设最小索引位置为1
//        int min = arr[1];//最小值为arr[1]
//        //从索引1的下一位开始比较
//        for (int i = 1 + 1 ; i <  arr.length ; i++) {
//            if (min > arr[i]){
//                //如果最小值大于arr[i]
//                //重置minIndex和min
//                minIndex = i;
//                min = arr[i];
//            }
//        }
//        //如果最小值索引不等于1，则交换
//        if (minIndex != 1){
//            arr[1] = min;
//            arr[minIndex] = arr[1];
//        }
//    }

