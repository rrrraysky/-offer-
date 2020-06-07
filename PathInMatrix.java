package cn.luo.leetcode.OfferSecond1_40;

public class PathInMatrix {
    public static void main(String[] args) {

    }
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==0) return false;
        int row=board.length;
        int col=board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(dfs(board,i,j,0,word)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,int i,int j,int index,String word){
        if(i<0||j<0||i>board.length-1||j>board[0].length-1||board[i][j]!=word.charAt(index)){
            return false;
        }
        if(index==word.length()-1) return true;
        char temp=board[i][j];
        board[i][j]='#';
        boolean res=dfs(board,i+1,j,index+1,word)||dfs(board,i-1,j,index+1,word)||
                dfs(board,i,j+1,index+1,word)||dfs(board,i,j-1,index+1,word);
        board[i][j]=temp;
        return res;
    }
}
