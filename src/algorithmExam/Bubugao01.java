package algorithmExam;

import java.util.Scanner;

/**
 * @author Epic
 * @create 2021-09-14 10:21
 * @Description 接雨水
 */
public class Bubugao01 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] num  = new int[100];
    int count = 0;
    while(sc.hasNext()){
      num[count] = sc.nextInt();
      count++;
    }
    int i = 0,j = num.length-1,res = 0;
    while(i < j) {
      res = num[i] < num[j] ? Math.max(res,(j-i)*num[i++]) :Math.max(res,(j-i)*num[j--]);
    }

    System.out.println(res);
  }
}
