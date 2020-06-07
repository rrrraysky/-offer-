package cn.luo.leetcode.OfferSecond1_40;

public class isNumber {
    public boolean isNumber(String s) {
        if(s==null||s.length()==0) return false;
        boolean numSeen=false;
        boolean dotSeen=false;
        boolean eSeen=false;
        char[] c=s.trim().toCharArray();
        for(int i=0;i<c.length;i++){
            if(c[i]>='0'&&c[i]<='9'){
                numSeen=true;
            }else if(c[i]=='.'){
                if(eSeen||dotSeen){
                    return false;
                }
                dotSeen=true;
            }else if(c[i]=='e'||c[i]=='E'){
                if(eSeen||!numSeen){
                    return false;
                }
                eSeen=true;
                numSeen=false;//e出现后重置numSeen，因为要确定e后面接了数字
            }else if(c[i]=='+'||c[i]=='-'){
                if(i!=0&&c[i-1]!='e'&&c[i-1]!='E'){
                    return false;
                }
            }else{
                return false;
            }
        }
        return numSeen;
    }
}
