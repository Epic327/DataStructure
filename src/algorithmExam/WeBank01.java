package algorithmExam;

import java.util.Scanner;

/**
 * @author Epic
 * @create 2021-09-10 20:45
 * @Description 方程是否有解
 */
public class WeBank01 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n  = sc.nextInt();
    int[] num = new int[n];
    for (int i = 0; i < n; i++) {
      num[i] = sc.nextInt();
    }

    for (int i = 0; i < n; i++) {
      if (getKey(num[i],num)){
        System.out.println("YES");
      }else {
        System.out.println("NO");
      }
    }

  }
  public static boolean getKey(int n ,int[] num){
    int res = 0;
    int a = 100;
    for (int j = 1; j < a; j++) {
      for (int k = 1; k < a; k++) {
        for (int l = 1; l < a; l++) {
          if(n == (j*j*j*j*j)+(k*k*k*k)+(l*l*l)){
            res = 1;
            return true;
          }else{
            continue;
          }
        }
      }
    }
    return res == 1 ? true:false;
  }

}
