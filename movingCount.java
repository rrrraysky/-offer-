package cn.luo.leetcode.OfferSecond1_40;
//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

public class movingCount {
    public static void main(String[] args) {
        movingCount s=new movingCount();
        int m=20,n=20,k=15;
        System.out.println(s.movingCount(m,n,k));
    }
    public int movingCount(int m, int n, int k) {
        if(m==0||n==0) return 0;
        boolean[][] visited=new boolean[m][n];
        return dfs(0,0,0,0,m,n,k,visited);
    }
    public int dfs(int i,int j,int si,int sj,int m,int n,int k,boolean[][] visited){
        if(i<0||j<0||i>=m||j>=n||visited[i][j]||(si+sj)>k){
            return 0;
        }
        visited[i][j]=true;
        //向下向右搜索
        return 1+dfs(i+1,j,(i+1)%10==0?(si-8):(si+1),sj,m,n,k,visited)+dfs(i,j+1,si,(j+1)%10==0?(sj-8):(sj+1),m,n,k,visited);
    }
}
