package com.datastructure.search;

/**@Description 插值查找
 * @author Epic
 * @create 2021-03-20 21:21
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };
        int index = insertValueSearch(arr, 0, arr.length - 1, 89);
        System.out.println("index = " + index);
    }

    public static int insertValueSearch(int[] arr, int left, int right, int findVal){
        //方法调用的次数
        System.out.println("被调用~~~~");;
        //先判断什么时候退出递归
        if (left > right) {
            return -1;
        }

        //定义mid 自适应
        int mid = left + (right - left) * (findVal - left) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        //判断
        if (findVal > midVal) {
            //向右递归查找
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            //向左递归查找
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            //找到了
            return mid;
        }


    }
}
