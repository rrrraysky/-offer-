package cn.luo.leetcode.OfferSecond1_40;

public class findRepeatNumber {
    public static void main(String[] args) {
        int[] nums={2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }
    public static int findRepeatNumber(int[] nums) {
        if(nums==null||nums.length==0) return -1;
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if(nums[nums[i]]==nums[i]){
                    return nums[i];
                }
                int temp=nums[i];
                nums[i]=nums[nums[i]];
                nums[temp]=temp;
            }
        }
        return -1;
    }
}
