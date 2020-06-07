package cn.luo.leetcode.OfferSecond1_40;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class permutation {
    public String[] permutation(String s) {
        List<String> res=new ArrayList<>();
        char[] c=s.toCharArray();
        dfs(c,res,0);
        return res.toArray(new String[res.size()]);
    }
    private void dfs(char[] c,List<String>res,int k){
        if(k==c.length-1){
            res.add(String.valueOf(c));//到达末尾
            return;
        }
        Set<Character> set=new HashSet<>();
        for(int i=k;i<c.length;i++){
            if(set.contains(c[i])){
                continue;//剪枝
            }
            set.add(c[i]);
            //将之后的所有字符和当前位置k上的字符交换
            swap(c,i,k);
            dfs(c,res,k+1);
            swap(c,i,k);
        }
    }
    private void swap(char[] c,int x,int y){
        char temp=c[x];
        c[x]=c[y];
        c[y]=temp;
    }
}
