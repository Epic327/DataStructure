package com.datastructure.sort;

import java.util.Arrays;

/**@Description 基数排序
 * @author Epic
 * @create 2021-03-17 20:43
 */
public class RedixSort {
    public static void main(String[] args) {
        int arr[] = { 53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println("基数排序后 " + Arrays.toString(arr));
    }

    public static void radixSort(int[] arr){
        //根据arr中最大的数，来确定一共遍历几轮
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        //找到最大值后，确认一共有几位
        int maxLen = (max + "").length();

        //创建一个二维数组，来表示10个桶,每个桶的容量考虑最坏的情况就是arr.length
        int[][] bucket = new int[10][arr.length];

        //定义一个一维数组，来表示每个桶装了多少数据
        //比如：bucketElementCounts[0] , 记录的就是  bucket[0] 桶的放入数据个数
        int[]  bucketElementsCounts = new int[10];

        //一共遍历maxLen轮
        for (int i = 0,n = 1 ; i < maxLen; i++, n *=10) {
            //先把数组的每个数的额个位数得到
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                //然后根据每个数的个位数，放入与之对应的桶中
                bucket[digitOfElement][bucketElementsCounts[digitOfElement]] = arr[j];
                //每个桶加入数后，就++
                bucketElementsCounts[digitOfElement]++;
            }
            //按照上述规则放入桶中后，然后再依次取出每个桶的数，加入到arr中
            //index :表示，数组的下标
            int index = 0;

            for (int k = 0; k < bucketElementsCounts.length; k++) {
                //先判断桶中是否有数，有就取出
                if (bucketElementsCounts[k] != 0 ){
                    //循环取出每一个桶中的所有数据，按照顺序放入arr中
                    for (int l = 0; l < bucketElementsCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                //取完所有的数后，要记得给所有的桶的数据个数置0
                bucketElementsCounts[k] = 0;
            }
        }



        // int arr[] = { 53, 3, 542, 748, 14, 214}
//        //先写第一轮，预计效果是【542，53，3，14，214，748】
//        //先把数组的每个数的额个位数得到
//        for (int i = 0; i < arr.length; i++) {
//            int digitOfElement = arr[i] / 1 % 10;
//            //然后根据每个数的个位数，放入与之对应的桶中
//            bucket[digitOfElement][bucketElementsCounts[digitOfElement]] = arr[i];
//            //每个桶加入数后，就++
//            bucketElementsCounts[digitOfElement]++;
//        }
//        //按照上述规则放入桶中后，然后再依次取出每个桶的数，加入到arr中
//        //index :表示，数组的下标
//        int index = 0;
//
//        for (int k = 0; k < bucketElementsCounts.length; k++) {
//            //先判断桶中是否有数，有就取出
//            if (bucketElementsCounts[k] != 0 ){
//                //循环取出每一个桶中的所有数据，按照顺序放入arr中
//                for (int l = 0; l < bucketElementsCounts[k]; l++) {
//                    arr[index++] = bucket[k][l];
//                }
//            }
//            //取完所有的数后，要记得给所有的桶的数据个数置0
//            bucketElementsCounts[k] = 0;
//        }

    }
}
