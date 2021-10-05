package algorithmExam;

import java.util.Scanner;

/**
 * @author Epic
 * @create 2021-09-10 19:24
 */
public class Mt01 {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int num = in.nextInt();

    int[] m = {1, 5, 10, 20, 50, 100}; // 保存基本面额的数组
    long[] data = new long[num+1]; // 保存计算数据的数组
    for(int i = 0; i <= num; i++) { // 边界条件A(n,1) = 1 (n>=0)
      data[i] = 1;
    }
    for(int i = 1; i < 6; i++) { // 基本面额从5开始，因为1元情况在数组初始化时已经写入了
      for (int n = 1; n <= num; n++) { // n从1开始，保证了边界条件A(0,m)=1 (m=1,5,10,20,50,100)
        if (n >= m[i]) {
          data[n] += data[n - m[i]]; // 状态转移方程
        }
      }
    }
    System.out.println(data[num]);
    in.close();

  }
}
