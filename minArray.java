package cn.luo.leetcode.OfferSecond1_40;

public class minArray {
    public static void main(String[] args) {
        int[] num={2,2,2,0,1};
        System.out.println(minArray(num));
    }
    public static int minArray(int[] numbers){
        int len=numbers.length;
        if(len==0) return 0;
        int left=0;
        int right=len-1;
        while (left<right){
            int mid=(left+right)/2;
            if(numbers[mid]>numbers[right]){
                left=mid+1;
            }else if(numbers[mid]<numbers[right]){
                right=mid;
            }else{
                right--;
            }
        }
        return numbers[left];
    }
}
