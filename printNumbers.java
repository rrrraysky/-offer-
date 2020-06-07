package cn.luo.leetcode.OfferSecond1_40;

public class printNumbers {
    public static void main(String[] args) {
        printNumbers s=new printNumbers();
        s.print1ToMaxOfNDigits(2);
    }
    //n可能非常大，需要char数组来表示
    public void print1ToMaxOfNDigits(int n) {
        if(n<0) return;
        char[] number=new char[n];
        print1ToMaxOfNDigits(number, 0);
    }
    private void print1ToMaxOfNDigits(char[] number,int n) {
        if(n==number.length){
            printNumber(number);
            return;
        }
        for(int i=0;i<10;i++){
            number[n]=(char)(i+'0');
            print1ToMaxOfNDigits(number,n+1);
        }
    }
    private void printNumber(char[] number){
        int index=0;
        while (index<number.length&&number[index]=='0'){
            index++;
        }
        while (index<number.length){
            System.out.print(number[index++]);
        }
        System.out.println();
    }
}
