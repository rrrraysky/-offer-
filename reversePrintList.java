package cn.luo.leetcode.OfferSecond1_40;

import cn.luo.leetcode.OfferFirst.ListNode;

import java.util.ArrayList;
import java.util.List;

public class reversePrintList {
    public static void main(String[] args) {

    }
    public int[] reversePrint(ListNode head) {
        List<Integer> res=new ArrayList<>();
        recur(head,res);
        int[] ans=new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }
        return ans;
    }
    public void recur(ListNode head,List<Integer> res){//每次调用递归都是新的节点
        if(head==null) return;
        res.add(head.val);
        recur(head.next,res);
    }
}
