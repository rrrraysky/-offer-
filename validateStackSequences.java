package cn.luo.leetcode.OfferSecond1_40;

import java.util.Stack;

public class validateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<>();
        int index=0;
        for(int i=0;i<pushed.length;i++){
            stack.push(pushed[i]);
            while (!stack.isEmpty()&&index<popped.length&&stack.peek()==popped[index]){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
