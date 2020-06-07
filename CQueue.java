package cn.luo.leetcode.OfferSecond1_40;
//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
// 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

import java.util.Stack;

public class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int size;
    public CQueue(){
        stack1=new Stack<>();
        stack2=new Stack<>();
        size=0;
    }
    public void appendTail(int value) {
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        size++;
    }
    public int deleteHead() {
        if(size==0) return -1;
        size--;
        return stack1.pop();
    }
}
