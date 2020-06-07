package cn.luo.leetcode.OfferSecond1_40;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack1,stack2;
    public MinStack(){
        stack1=new Stack<>();
        stack2=new Stack<>();
    }
    public void push(int x){
        stack1.push(x);
        while (stack2.isEmpty()||x<=stack2.peek()){//几个最小值，保存几个最小的
            stack2.push(x);
        }
    }
    public void pop(){
        if(stack1.pop().equals(stack2.peek())){//不能用等于，int转换为了Integer
            stack2.pop();
        }
    }
    public int top(){
        return stack1.peek();
    }
    public int min(){
        return stack2.peek();
    }
}
