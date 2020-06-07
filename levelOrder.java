package cn.luo.leetcode.OfferSecond1_40;
import cn.luo.leetcode.OfferFirst.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            int sz=queue.size();
            for(int i=0;i<sz;i++){
                TreeNode cur=queue.poll();
                temp.add(cur.val);
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
            }
            res.add(new ArrayList<>(temp));
        }
        return res;
    }
}
