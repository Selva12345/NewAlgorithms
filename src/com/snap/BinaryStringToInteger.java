package com.snap;

public class BinaryStringToInteger {
    public static void main(String[] args) {
        BinaryStringToInteger b=new BinaryStringToInteger();
        b.convertToInteger("1001","10101");
    }
    public  String convertToInteger(String s1,String s2){
        int prev=0, remainder=0;
        int i=s1.length(),j=s2.length();
        while(i>0|| j>0){
            int a=s1.charAt(i)-'0';
            int b=s2.charAt(j)-'0';
            int sum=a+b+prev;
            remainder = sum%2;
            int cur=sum/2;
            if(sum==2){

            }
        }
        return "";
    }
}
