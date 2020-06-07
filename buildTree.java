package cn.luo.leetcode.OfferSecond1_40;



import cn.luo.leetcode.OfferFirst.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class buildTree {
    //分治就完事了
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildTreeHelper(preorder,0,preorder.length-1,0,inorder.length-1,map);
    }
    public TreeNode buildTreeHelper(int[] preorder, int preL,int preR,int inL,int inR,Map<Integer,Integer> map){
        if(preL>preR){
            return null;
        }
        int inRoot=map.get(preorder[preL]);//中序遍历中，root节点的引索
        TreeNode root=new TreeNode(preorder[preL]);
        root.left=buildTreeHelper(preorder,preL+1,preL+inRoot-inL,inL,inRoot-1,map);
        root.right=buildTreeHelper(preorder,preL+1+inRoot-inL,preR,inRoot+1,inR,map);
        return root;
    }
}
