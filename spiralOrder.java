package cn.luo.leetcode.OfferSecond1_40;

public class spiralOrder {
    public static void main(String[] args) {

    }
    public int[] spiralOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return new int[0];
        int left=0;
        int right=matrix[0].length-1;
        int top=0;
        int bottom=matrix.length-1;
        int[] res=new int[(right+1)*(bottom+1)];
        int index=0;
        while (true){
            for(int i=left;i<=right;i++){
                res[index++]=matrix[top][i];
            }
            if(++top>bottom) break;
            for(int j=top;j<=bottom;j++){
                res[index++]=matrix[j][right];
            }
            if(--right<left) break;
            for(int k=right;k>=left;k--){
                res[index++]=matrix[bottom][k];
            }
            if(--bottom<top) break;
            for(int l=bottom;l>=top;l--){
                res[index++]=matrix[l][left];
            }
            if(++left>right) break;
        }
        return res;
    }
}
