package jzoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Epic
 * @create 2021-09-08 9:35
 */
public class PrimeNum {
  public static void main(String[] args) {
    int n  = 100;
    PrimeNum primeNum = new PrimeNum();
    int[] num = primeNum.primeFactorization(n);
    System.out.println(Arrays.toString(num));

  }


  public int[] primeFactorization (int n) {
    // write code here
    List<Integer> a =new ArrayList();
    for(int i = 2;i<=n;i++){
      while( n%i ==0){
        a.add(i);
        n = n/i;
      }
    }
    int[] b = a.stream().mapToInt(Integer::valueOf).toArray();
    return b;
  }

}
