package cn.luo.leetcode.OfferSecond1_40;

public class isMatch {
    public static void main(String[] args) {
        String s="aab";
        String p="c*a*b";
        System.out.println(isMatch_dp(s,p));
    }
    //dp,我们从后往前匹配
    public static boolean isMatch_dp(String s, String p){
        int n=s.length();
        int m=p.length();
        boolean[][] dp=new boolean[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(j==0){
                    dp[i][j]=i==0;
                }else{//p不是空的
                    if(p.charAt(j-1)!='*'){
                        if(i>0&&(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.')){
                            dp[i][j]=dp[i-1][j-1];
                        }
                    }else{//p结尾是'*'
                        //不考虑'*'和前面的,这里要用“或”，因为看和不看只要有一个是true就可以继续匹配
                        if(j>=2){
                            dp[i][j] |= dp[i][j-2];
                        }
                        //看
                        if(i>=1&&j>=2&&(s.charAt(i-1)==p.charAt(j-2)||p.charAt(j-2)=='.')){
                            dp[i][j] |= dp[i-1][j];
                        }
                    }

                }
            }
        }
        return dp[n][m];
    }

    //回溯
    public boolean isMatch(String s, String p){
        if(p.isEmpty()) return s.isEmpty();
        boolean headMatched=!s.isEmpty()&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.');
        if(p.length()>=2&&p.charAt(1)=='*') {//如果p的第一个元素的下一个元素是*
            return isMatch(s,p.substring(2))||//删除*和前面的字符
                    (headMatched&&isMatch(s.substring(1),p));//不删除p*和前面的字符，去掉一个s第一个字符
        }else if(headMatched){
            return isMatch(s.substring(1),p.substring(1));
        }else{
            return false;
        }
    }
}
