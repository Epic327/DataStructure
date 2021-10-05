package com.datastructure.sort;

import java.util.Arrays;

/**@Description 归并排序
 * @author Epic
 * @create 2021-03-16 20:34
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
//        mergeSort(int[] arr , int mid , int left , int right , int[] temp);
        System.out.println(Arrays.toString(arr));
    }

    //合并的过程
    public static void merge(int[] arr,int left , int right,int mid, int[] temp){
        //先定义两个指针
        int i = left;
        int j  = mid + 1;
        //定义一个temp数组的指针
        int t = 0;

        //(一)
        //先把左右两边(有序)的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止 即效果是temp = [4,5,8,7,1,3,2,6]
        while (i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[t] = arr[i];
                i++;
                t++;
            }else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
        //(二)
        //把有剩余数据的一边的数据依次全部填充到temp

        //(三)
        //将temp数组的元素拷贝到arr
        //注意，并不是每次都拷贝所有
    }
}
