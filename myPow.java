package cn.luo.leetcode.OfferSecond1_40;

public class myPow {
    public static void main(String[] args) {
        System.out.println(myPow(2,4));
    }
    //时间O(log2n)
    public static double myPow(double x, int n) {
        if(x==0) return 0;
        long b=n;
        if(b<0){
            b=-b;
            x=1/x;
        }
        double res=1.0;
        while (b>0){
            if((b&1)==1){
                res*=x;
            }
            b>>=1;
            x*=x;
        }
        return (double)res;
    }
}
