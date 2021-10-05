package datastructure.sort;

import java.util.Arrays;

/**@Description 快速排序
 * @author Epic
 * @create 2021-03-15 21:09
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{-9,78,0,23,-567};
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    //定义双指针，然后利用左右递归
    public static void quickSort(int[] arr , int left ,int right){

        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        //只要 l < r,就一直循环
        while ( l < r) {

            //先把比pivot小的数放在左边
            while (arr[l] < pivot) {
                l += 1;
            }
            //把比piovt大的数放在右边
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果l >=r说明pivot的左右两的值，已经按照左边全部是小于等于pivot值，右边全部是大于等于pivot的值
            if (l >= r) {
                break;
            }
            //否者就交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot值，即 r-- 前移
            if (arr[l] == pivot) {
                r--;
            }
            //如果交换完后，发现这个arr[r] == pivot值，即 l++ 后移
            if (arr[r] == pivot) {
                l++;
            }
        }
        //如果l == r,必须l++ ,r--,否则出现栈溢出
        if(l == r){
            l += 1;
            r -= 1 ;
        }
        //左递归
        if (left < r){
            quickSort(arr,left,r);
        }
        //右递归
        if (right > l){
            quickSort(arr,l,right);
        }
    }
}
