package cn.luo.leetcode.OfferSecond1_40;

import cn.luo.leetcode.OfferFirst.ListNode;

public class reverseList {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode pre=head;
        ListNode cur=null;
        ListNode temp=null;
        while (pre!=null){
            temp=pre.next;
            pre.next=cur;
            cur=pre;
            pre=temp;
        }
        return cur;
    }
}
