package jzoffer;

import org.junit.Test;

/**
 * @author Epic
 * @create 2021-05-11 10:33
 */
public class Fibna {
    @Test
    public void test(){
        int fib = fib(3);
        System.out.println(fib);
    }

    public int fib(int n){
        //利用递归
//        if(n==0){
//           return 0;
//        }else if(n==1){
//            return 1;
//        }else{
//            return fib(n-1)+fib(n-2);
//        }
        //在递归的基础上，新建一个数组，记忆化递归法
//        public int fib(int n) {
//            if(n == 0) return 0;
//            int[] dp = new int[n + 1];
//            dp[0] = 0;
//            dp[1] = 1;
//            for(int i = 2; i <= n; i++){
//                dp[i] = dp[i-1] + dp[i-2];
//                dp[i] %= 1000000007;
//            }
//            return dp[n];
//        }

        //利用动态规划
        int a = 0,b = 1 ,sum;
        for (int i = 0; i < n; i++) {
            sum = (a+b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
