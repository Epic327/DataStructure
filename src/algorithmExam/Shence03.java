package algorithmExam;

import java.util.Scanner;

/**
 * @author Epic
 * @create 2021-10-02 17:24
 */
public class Shence03 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // 避免越界，就用long
    while (scanner.hasNextLong()) {
      long x = scanner.nextLong();
      long y = scanner.nextLong();
      long m = scanner.nextLong();
      long count = 0;
      boolean flag = true;
      if (m <= x || m <= y) {
        count = 0;
        flag = false;
      } else {
        // m  > x && m > y 只要有一个为0就不可能
        if (x == 0 || y == 0) {
          count = -1;
          flag = false;
        }
        if (m != 0 && x + y == 0) {
          count = -1;
          flag = false;
        }
        //
        if ( m > 0 && x < 0 && y < 0) {
          count = -1;
          flag = false;
        }
      }
      while (flag && x < m && y < m) {
        // 选择一个较小的进行替换,当x /y 等于m时退出循环
        if (x <= y) {
          x += y;
        } else {
          y += x;
        }
        count++;
      }
      System.out.println(count);
    }
  }

}
