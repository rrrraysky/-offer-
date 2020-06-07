package cn.luo.leetcode.OfferSecond1_40;

import java.util.List;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class copyRandomList {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        copy(head);
        randomDirect(head);
        return reList(head);
    }
    private void copy(Node head){
        while (head !=null){
            Node clone=new Node(head.val);
            Node temp=head.next;
            head.next=clone;
            clone.next=temp;
            head=temp;
        }
    }
    //任意指针在复制后的链表上也体现
    private void randomDirect(Node head){
        while (head!=null){
            Node clone=head.next;
            if(head.random!=null){
                clone.random=head.random.next;
            }
            head=clone.next;
        }
    }
    //重新分开链接，至少分为两个单节点的链表
    private Node reList(Node head){
        Node cloneNode=head.next;
        Node clonehead=cloneNode;//复制链表的头节点
        head.next=cloneNode.next;
        head=head.next;//head可能为空
        while (head!=null){//head不是null
            cloneNode.next=head.next;
            head.next=head.next.next;//head可能为空
            head=head.next;
            cloneNode=cloneNode.next;
        }
        return clonehead;
    }
}
