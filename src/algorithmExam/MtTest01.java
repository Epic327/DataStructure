package algorithmExam;

import java.math.BigDecimal;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Epic
 * @create 2021-09-11 14:24
 */
public class MtTest01 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<Double> list = new ArrayList<>();
    while (sc.hasNextInt()){
      double n = sc.nextInt();
      int m  = sc.nextInt();
      double res = 0;
      double temp = 0;
      double nn = n;
      for (int i = 0; i < m-1 ; i++) {
        temp = Math.sqrt(nn);
        res += temp;
        nn = temp;
      }
      list.add(res+n);
    }

    for (Double num:list) {
      BigDecimal b = new BigDecimal(num);
      num = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
      System.out.println(num);
    }
  }

}
