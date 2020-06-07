package cn.luo.leetcode.OfferSecond1_40;

import cn.luo.leetcode.OfferFirst.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class pathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        List<Integer> path=new ArrayList<>();
        dfs(root,sum,path,res);
        return res;
    }
    public void dfs(TreeNode root,int sum,List<Integer> path,List<List<Integer>> res){
        //叶子节点就是base case咯
        if(root.left==null&&root.right==null){
            if(root.val==sum){
                path.add(root.val);
                res.add(new ArrayList<Integer>(path));
                path.remove(path.size()-1);
            }
            return;
        }
        if(root.left==null){
            path.add(root.val);
            dfs(root.right,sum-root.val,path,res);
            path.remove(path.size()-1);
            return;
        }
        if(root.right==null){
            path.add(root.val);
            dfs(root.left,sum-root.val,path,res);
            path.remove(path.size()-1);
            return;
        }
        path.add(root.val);
        dfs(root.left,sum-root.val,path,res);
        path.remove(path.size()-1);
        path.add(root.val);
        dfs(root.right,sum-root.val,path,res);
        path.remove(path.size()-1);
    }
}
