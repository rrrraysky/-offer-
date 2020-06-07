package cn.luo.leetcode.OfferSecond1_40;

import cn.luo.leetcode.OfferFirst.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class mirrorTree {
    //递归
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null) return null;
        TreeNode temp=root.right;
        root.right=mirrorTree(root.left);
        root.left=mirrorTree(temp);
        return root;
    }
    public TreeNode mirrorTree_bfs(TreeNode root) {
        if(root==null) return null;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int sz=queue.size();
            for(int i=0;i<sz;i++){
                TreeNode cur=queue.poll();
                TreeNode temp=cur.left;
                cur.left=cur.right;
                cur.right=temp;
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }
            }
        }
        return root;
    }
}
