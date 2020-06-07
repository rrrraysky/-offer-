package cn.luo.leetcode.OfferSecond1_40;

import java.util.Stack;

public class verifyPostorder {
    public static void main(String[] args) {

    }
    //单调递增栈
    public boolean verifyPostorder_stackversion(int[] postorder) {
        Stack<Integer> stack=new Stack<>();
        int root=Integer.MAX_VALUE;
        for(int i=postorder.length-1;i>=0;i--){
            if(postorder[i]>root) return false;
            while (!stack.isEmpty()&&stack.peek()>postorder[i]){
                root=stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }
    //分治
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorderhelper(postorder,0,postorder.length-1);
    }
    public boolean verifyPostorderhelper(int[] postorder,int start,int end){
        if(start>end) return false;
        int ptr1=start;
        while(postorder[ptr1]<postorder[end]){
            ptr1++;
        }
        //此时ptr1的位置要么是根节点的右子树的最小值，要么就是根节点;
        //对于后序遍历，引索从ptr1到根节点前面一个的数值都是大于postorder[end]的
        int ptr2=ptr1;
        while (postorder[ptr2]>postorder[end]){
            ptr2++;
        }
        //对于后序遍历,start2==end,并且分治下去
        return ptr2==end&&verifyPostorderhelper(postorder,start,ptr1-1)&&verifyPostorderhelper(postorder,ptr1,ptr2-1);
    }
}
