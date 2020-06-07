package cn.luo.leetcode.OfferSecond1_40;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class getLeastNumbers {
    //快排变形
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length==0||k<1) return new int[0];
        return quickSearch(arr,0,arr.length-1,k-1);
    }
    private int[] quickSearch(int[] arr,int lo,int hi,int k){
        int m=partition(arr,lo,hi);
        if(m==k){
            return Arrays.copyOf(arr,k+1);
        }else if(m>k){
            return quickSearch(arr,lo,m-1,k);
        }else{
            return quickSearch(arr,m+1,hi,k);
        }
    }
    private int partition(int[] arr,int lo,int hi){
        int i=lo,j=hi+1;
        int v=arr[lo];
        while(true){
            while(++i<hi&&arr[i]<v);
            while(--j>lo&&arr[j]>v);
            if(i>=j) break;
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        arr[lo]=arr[j];
        arr[j]=v;
        return j;
    }



    //堆排序，java默认最小堆，每次弹出最小的数，实现简单，不推荐
    public int[] getLeastNumbers_second(int[] arr, int k) {
        Queue<Integer> qmax=new PriorityQueue<>((x,y)->y-x);
        for(int x:arr){
            qmax.offer(x);
            if(qmax.size()>k){
                qmax.poll();
            }
        }
        int[] res=new int[k];
        int index=0;
        for(int y:qmax){
            res[index++]=y;
        }
        return res;
    }
}
