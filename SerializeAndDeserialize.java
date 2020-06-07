package cn.luo.leetcode.OfferSecond1_40;

import cn.luo.leetcode.OfferFirst.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserialize {
    public String serialize(TreeNode root) {
        if(root==null) return "[]";
        StringBuilder res=new StringBuilder("[");
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int sz=queue.size();
            for(int i=0;i<sz;i++){
                TreeNode cur=queue.poll();
                if(cur!=null){
                    res.append(cur.val+",");
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }else{
                    res.append("null,");
                }
            }
        }
        res.deleteCharAt(res.length()-1);
        res.append("]");
        return res.toString();
    }
    //其实就是知道层序遍历，去恢复二叉树
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String[] vals=data.substring(1,data.length()-1).split(",");
        TreeNode root=new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue=new LinkedList<>();
        int i=1;
        while (!queue.isEmpty()){
            TreeNode cur=queue.poll();
            //vals[i]==null的话就不更新左右子节点
            if(!vals[i].equals("null")){
                TreeNode node=new TreeNode(Integer.parseInt(vals[i]));
                cur.left=node;
                queue.offer(node);
            }
            i++;
            if(!vals[i].equals("null")){
                TreeNode node=new TreeNode(Integer.parseInt(vals[i]));
                cur.right=node;
                queue.offer(node);
            }
            i++;
        }
        return root;
    }
}
