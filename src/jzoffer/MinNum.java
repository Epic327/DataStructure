package jzoffer;

import org.junit.Test;

import javax.swing.text.Element;

/**
 * @author Epic
 * @create 2021-05-12 16:21
 */
public class MinNum {
    @Test
    public void test(){
        int [] nums = {7,0,1,1,1,1,1,2,3,4};
        int i = minArray(nums);
        System.out.println(i);
    }

    public int minArray(int[] nums){
        //二分查找
        //定义两个指针 i，j
        int i = 0;
        int j = nums.length-1;
        //二分循环查找
        while (i < j){
            int m = (i + j) / 2;
            if (nums[m] < nums[j]){
                //这说明m肯定属于右排序数组，x属于【i，m】
                j = m;
            }else if (nums[m] > nums[j]){
                //这说明m肯定属于左排序数组，x属于【m+1，j】
                i = m+1;
            }else {
                j--;
            }
        }
        return nums[i];

    }

}
