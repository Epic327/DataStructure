package com.datastructure.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Epic
 * @create 2021-03-19 20:37
 */
public class BinarySearch {
    public static void main(String[] args) {
        //二分查找必须要求数组是有序的
        int arr[] = { 1, 8, 10, 89,1000,1000,1000,1000, 1234 };
        List<Integer> resIndex = binarySearch(arr, 0, arr.length - 1, 1000);
		System.out.println("resIndex=" + resIndex);
    }

    public static  List<Integer> binarySearch(int[] arr , int left, int right , int findVal){
        //采用左右递归的方法
        //如果left 《 right ，就退出递归
        if (left > right){
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        //如果findVal 》 midVal ，则向右递归查找
        if (findVal > midVal){
            return binarySearch(arr,mid+1, right , findVal);
        }//反之 ，则向左递归查找
        else if (findVal < midVal){
            return binarySearch(arr,left,mid-1, findVal);
        }else {
            //找到了，如果有多个值，就创建一个list来存放
            List<Integer> arrayList = new ArrayList<>();

            //找到mid后，向左向右扫描，把找到的值都加入到list
            //定义一个向左扫描的指针
            int leftTemp = mid - 1;
            while (true){
                //判断什么时候结束扫描
                if (leftTemp < 0 || arr[leftTemp] != findVal){
                    break;
                }else {
                    //把扫描到的值加入到list
                    arrayList.add(leftTemp);
                }
                leftTemp--;
            }
            //把中间值放在中间
            arrayList.add(mid);

            //定义一个向右扫描的指针
            int rightTemp = mid + 1;
            while (true){
                //判断什么时候结束扫描
                if (rightTemp > arr.length || arr[rightTemp] != findVal){
                    break;
                }else {
                    //把扫描到的值加入到list
                    arrayList.add(rightTemp);
                }
                rightTemp++;
            }
            return arrayList;
        }
    }
}
