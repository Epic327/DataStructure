package algorithmExam;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Epic
 * @create 2021-09-30 19:41
 */
public class Futu01 {
  public static void main(String[] args) {
    int[] t1 = {9,3,1,10};
    int i = maxDistance(t1);
    System.out.println(i);
  }
  public static int maxDistance (int[] arr) {
    // write code here
    Arrays.sort(arr);
    int max = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i+1; j < arr.length ; j++) {
        max = Math.max(max,arr[j] - arr[j-1]);
      }
    }
    return max;
  }
}
