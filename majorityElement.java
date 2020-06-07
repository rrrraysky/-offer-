package cn.luo.leetcode.OfferSecond1_40;

public class majorityElement {
    /**
     * 摩尔投票法原理：设众数是1，非众数是-1，对所有的数有和>0
     * 构建正负抵消：如果有一个数是我们的众数，剩下的和任然大于0
     * 如果不是，抵消的数字中，最多有一半的数字是众数，剩下的和只有变大的趋势
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int majoritynum=0;
        int votes=0;
        for(int num:nums){
            //votes=0,说明之前的已经抵消
            if(votes==0) majoritynum=num;
            if(num==majoritynum){
                votes++;
            }else{
                votes--;
            }
        }
        return majoritynum;
    }
}
