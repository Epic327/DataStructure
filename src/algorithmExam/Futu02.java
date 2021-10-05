package algorithmExam;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Epic
 * @create 2021-09-30 19:48
 */
public class Futu02 {
  public static void main(String[] args) {
    int[] t1 = {8};
    int i = maxProfit(t1);
    System.out.println(i);
  }
  public static int maxProfit (int[] prices) {
    // write code here
    int min = prices[0];
    int max = 0;
    //new 一个数组用来装最大值
    int[] res = new int[prices.length];
    for (int i = 1,j=0; i < prices.length && j < prices.length; i++,j++) {
      if (prices[i] - min > 0){
        max =  prices[i] - min ;
        res[j] = max;
      }else{
        min = prices[i]; //如果当前值小于min，就重新赋值
      }
    }
    Arrays.sort(res);
    int ac = 0;
    for (int i = res.length-1; i > res.length-3; i--) {
      ac += res[i];
    }
    return ac;
  }
}
