package algorithmExam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Epic
 * @create 2021-10-02 17:23
 */
public class ShenceData02 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String sn = sc.nextLine();
    int n = Integer.parseInt(sn);
    int[][] ints = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int i1 = Integer.parseInt(sc.nextLine());
        ints[i][j] = i1;
      }
    }
//    int n = 3;
//    int[][] ints = {{1,2,3},{4,5,6},{7,8,9}};
    //先沿着对角线翻转
    for (int i = 0; i < n ;i++){
      for (int j = 0; j < i; j++) {
        int temp = ints[i][j];
        ints[i][j] = ints[j][i];
        ints[j][i] = temp;
      }
    }
    //再沿着垂直竖线翻转
    for (int i = 0; i < n ;i++){
      for (int j =0,k = n-1; j < k; j++,k--) {
        int temp = ints[i][k];
        ints[i][k] = ints[i][j];
        ints[i][j] = temp;
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.println(ints[i][j]);
      }
    }


  }
}
