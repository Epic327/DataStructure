package com.datastructure.sort;

import java.util.Arrays;

/**@Description 插入排序
 * @author Epic
 * @create 2021-03-12 22:11
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 4, 2};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            //初始化插入索引
            int insertIndex = i - 1;
            //初始化待插入值
            int insertValue = arr[i];
            //先测试一下第一轮，{3，1，4，2} -》 {1，3，4，2}

            //循环条件：insertIndex 大于等于0 ，并且待插入值小于arr[insertIndex]
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                //把arr[insertIndex]后移，即效果是{3，3，4，2}
                arr[insertIndex + 1] = arr[insertIndex];
                //此时insertIndex = -1
                insertIndex--;
            }
            //退出循环后,即把insertValue插入到待插入的地方 -->{1，3，4，2}
            //如果insertIndex + 1 = i则说明没有进入到while循环
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertValue;
            }
        }
    }


}
