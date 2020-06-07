package cn.luo.leetcode.OfferSecond1_40;

import cn.luo.leetcode.OfferFirst.TreeNode;

public class isSubstructure {
    //时间复杂度 O(MN)其中M,N分别为树A和树B的节点数量；先序遍历树A占用O(M)每次调用recur(A, B)判断占用O(N)。
    //作者：jyd
    //链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/mian-shi-ti-26-shu-de-zi-jie-gou-xian-xu-bian-li-p/
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null||B==null) return false;
        return recur(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B);
    }
    public boolean recur(TreeNode A, TreeNode B) {
        //base case，B到达叶子节点就是true的
        if(B==null){
            return true;
        }
        if(A==null||B==null){
            return false;
        }
        if(A.val!=B.val){
            return false;
        }
        return recur(A.left,B.left)&&recur(A.right,B.right);
    }
}
