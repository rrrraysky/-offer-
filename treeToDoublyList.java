package cn.luo.leetcode.OfferSecond1_40;

class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;

    public Node1() {}

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val,Node1 _left,Node1 _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
//将该二叉搜索树转换成一个排序的循环双向链表
public class treeToDoublyList {
    Node1 pre,head;
    public Node1 treeToDoublyList(Node1 root) {
        if(root==null) return head;
        inorder(root);
        head.left=pre;//递归完成后，pre指向中序遍历最后一个节点
        pre.right=head;
        return head;
    }
    public void inorder(Node1 root){
        if(root==null) return;
        inorder(root.left);
        root.left=pre;
        if(pre!=null){
            //不是头结点
            pre.right=root;
        }
        pre=root;
        inorder(root.right);
    }
}
