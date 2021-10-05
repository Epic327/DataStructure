package jzoffer;

import org.junit.Test;

/**
 * @author Epic
 * @create 2021-05-11 16:05
 */
public class Dynamic {
    @Test
    public void test(){
        int fib = fib(3);
        System.out.println(fib);
    }

    public int fib(int n){
        if (n == 0 || n == 1){
            return  1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <=n ; i++) {
            dp[i] = (dp[i-1]+dp[i-2]) % 1000000007;
        }
        return dp[n];
    }
}
