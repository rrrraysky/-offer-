package cn.luo.leetcode.OfferSecond1_40;

import java.util.PriorityQueue;
import java.util.Queue;
// 堆的插入和弹出操作使用 O(log N)时间。
class MedianFinder {
    private Queue<Integer> lowpart;
    private Queue<Integer> highpart;
    int size;
    public MedianFinder(){
        lowpart=new PriorityQueue<>((x,y)->y-x);//低位是最大堆，每次弹出最大的元素
        highpart=new PriorityQueue<>();//小顶堆，每次弹出最小的
        size=0;
    }
    //维持highpart数目等于或者之比lowpart高一个
    public void addNum(int num) {
        size++;
        lowpart.offer(num);
        highpart.offer(lowpart.poll());
        if((size&1)==0){
            lowpart.offer(highpart.poll());
        }
    }
    public double findMedian(){
        if(size==0) return 0;
        if((size&1)==1){
            return (double)highpart.peek();
        }else{
            return (double)(highpart.peek()+lowpart.peek())/2;
        }
    }
}
