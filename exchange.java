package cn.luo.leetcode.OfferSecond1_40;

import java.util.Arrays;

public class exchange {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(exchange(a)));
    }
    public static int[] exchange(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int temp=0;
        while (left<right){
            //while ((nums[left]&1)==1){//每次判断while循环的时候，一定要注意越界问题！！
            while (left<nums.length&&(nums[left]&1)==1){
                left++;
            }
            while (right>=0&&(nums[right]&1)==0){
                right--;
            }
            if(left<right){
                temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
            }
        }
        return nums;
    }
    public static int[] exchange_v2(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int temp=0;
        while (left<right){
            while (left<right&&(nums[left]&1)==1){
                left++;
            }
            while (left<right&&(nums[right]&1)==0){
                right--;
            }
            temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
        }
        return nums;
    }
}
