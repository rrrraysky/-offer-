package cn.luo.leetcode.OfferSecond1_40;

public class hammingWeight {

    //n&(n−1) 解析： 二进制数字 n最右边的 1 变成 0 ，其余不变
    public int hammingWeight_best(int n) {
        int res = 0;
        while(n!=0){
            n&=(n-1);
            res++;
        }
        return res;
    }
    public int hammingWeight(int n) {
        int res = 0;
        while(n!=0){
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}
