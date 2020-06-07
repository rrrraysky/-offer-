package cn.luo.leetcode.OfferSecond1_40;

public class cuttingRope {
    public static void main(String[] args) {
        System.out.println(cuttingRope(10));
        System.out.println(cuttingRope_dp(10));
    }
    /**
     * 贪心算法,不考虑越界
     * @param n
     * @return
     */
    public static int cuttingRope(int n) {
        if(n<=3) return n-1;
        int a=n/3;
        int b=n%3;
        if(b==0){
            return (int)Math.pow(3,a);
        }else if(b==1){
            return (int)Math.pow(3,a-1)*4;
        }else{
            return (int)Math.pow(3,a)*2;
        }
    }
    //越界
    public static int cuttingRope_out(int n) {
        if(n<4) return n-1;
        int mod=(int)1e9+1;
        long res=1;
        while(n>4){
            n-=3;
            res*=3;
            res%=mod;
        }
        return (int)res;
    }


    public static int cuttingRope_dp(int n) {
        if(n==1||n==2)
            return 1;
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=1;
        //注意(i-j)与dp[i-j]的区别 i-j之前的绳子一次没切 dp[i-j]表示切了至少一次 两者也应比较
        for(int i=3;i<=n;i++){
            for(int j=i;j>i/2;--j){
                dp[i]=Math.max(Math.max(dp[j]*(i-j),j*(i-j)),dp[i]);
            }
        }
        return dp[n];
    }
}
