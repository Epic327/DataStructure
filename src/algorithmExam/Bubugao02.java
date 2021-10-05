package algorithmExam;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Epic
 * @create 2021-09-14 10:22
 * @Description 计算器
 */
public class Bubugao02 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    int calculate = calculate(s);
    System.out.printf("%.2f",calculate);
  }
  public static int calculate(String s) {
    Deque<Integer> ops = new LinkedList<Integer>();
    ops.push(1);
    int sign = 1;

    int ret = 0;
    int n = s.length();
    int i = 0;
    while (i < n) {
      if (s.charAt(i) == ' ') {
        i++;
      } else if (s.charAt(i) == '+') {
        sign = ops.peek();
        i++;
      } else if (s.charAt(i) == '-') {
        sign = -ops.peek();
        i++;
      } else if (s.charAt(i) == '(') {
        ops.push(sign);
        i++;
      } else if (s.charAt(i) == ')') {
        ops.pop();
        i++;
      } else {
        long num = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
          num = num * 10 + s.charAt(i) - '0';
          i++;
        }
        ret += sign * num;
      }
    }
    return ret;
  }


}
