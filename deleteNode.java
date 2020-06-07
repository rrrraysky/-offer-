package cn.luo.leetcode.OfferSecond1_40;

import cn.luo.leetcode.OfferFirst.ListNode;

public class deleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val==val) return head.next;
        ListNode pre=head;
        ListNode cur=head.next;
        while(cur!=null&&cur.val!=val){
            pre=pre.next;
            cur=cur.next;
        }
        if(cur!=null){
            pre.next=cur.next;
        }
        return head;
    }
}
