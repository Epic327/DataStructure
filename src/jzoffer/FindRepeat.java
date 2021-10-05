package jzoffer;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author Epic
 * @create 2021-03-10 20:22
 */
public class FindRepeat {
    int[] arr = new int[]{1,2,3,3,5};
    @Test
    public void test(){
        int repeat = findRepeat(arr);
        System.out.println(repeat);
    }
    public static int findRepeat(int[] arr){
        //创建一个哈希表
        HashSet<Integer> hashSet = new HashSet<>();
        //遍历
        for (int i = 0; i < arr.length; i++) {
            if (hashSet.contains(arr[i])){
                return arr[i];
            }
            hashSet.add(arr[i]);
        }
        return -1;
    }

}
