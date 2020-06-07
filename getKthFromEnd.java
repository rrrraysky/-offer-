package cn.luo.leetcode.OfferSecond1_40;

import cn.luo.leetcode.OfferFirst.ListNode;

public class getKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast=head;
        ListNode slow=head;
        for(int i=0;i<k;i++){
            if(fast!=null){
                fast=fast.next;
            }else{
                return null;//链表不够长
            }
        }
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
