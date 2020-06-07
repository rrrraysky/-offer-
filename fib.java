package cn.luo.leetcode.OfferSecond1_40;

public class fib {
    public static void main(String[] args) {
        System.out.println(fibnacci(5));
    }
    public static int fib(int n){
        if(n==0||n==1) return n;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%1000000007;
        }
        return dp[n];
    }
    public static int fibnacci(int n){
        int a=0;
        int b=1;
        int sum=0;
        for(int i=0;i<n;i++){
            sum=(a+b)%1000000007;
            a=b;
            b=sum;
        }
        return a;
    }
}
