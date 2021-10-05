package algorithmExam;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

/**
 * @author Epic
 * @create 2021-09-14 15:39
 */
public class Quna02 {
  public static void main(String[] args) {
    int[] t = new int[]{-1,1,4,-9,-8};
    int ss = solution(t);
    System.out.println(ss);
  }
  /* Write Code Here */
  public  static int solution(int[] arr) {
    Arrays.sort(arr);
    int[][] dp = new int[arr.length][arr.length];
    //初始化
    for (int i = 0; i <dp.length ; i++) {
      dp[i][i] = arr[i];
    }
    for (int i = 0; i < dp.length; i++) {
      for (int j = i+1; j < dp.length; j++) {
        dp[i][j] = dp[i][j-1] + arr[j]*(j+1-i);
      }
    }
    int max = 0;
    for (int i = 0; i < dp.length; i++) {
      for (int j = i+1; j < dp.length; j++) {
        if(max < dp[i][j]){
          max = dp[i][j];
        }
      }

    }
    return max;

  }
}
