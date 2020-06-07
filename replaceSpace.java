package cn.luo.leetcode.OfferSecond1_40;

public class replaceSpace {
    public static void main(String[] args) {

    }
    public String replaceSpace(String s) {
        int len=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<len;i++){
            if(s.charAt(i)==' '){
                sb.append("%20");
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
