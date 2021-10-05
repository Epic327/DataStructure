package jzoffer;

import org.junit.Test;

/**
 * @author Epic
 * @create 2021-03-10 20:43
 */
public class FindNum2D {
    @Test
    public void test(){
        int[][] arr = new int[][]{{1, 3}, {2, 3}, {3, 4}};
        boolean i = find(arr, 5);
        System.out.println(i);

    }
    public static boolean find(int[][] arr , int num){
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr[i].length ; j++) {
                if (arr[i][j] == num){
                    return true;
                }
            }
        }
        return false;
    }


}
