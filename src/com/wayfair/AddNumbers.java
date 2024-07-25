package com.wayfair;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddNumbers {
    public static void main(String[] args) {
        AddNumbers addNumbers=new AddNumbers();
        System.out.println(addNumbers.addStrings("123454558987666h7","58765847564387562934621391036462304235"));
    }
    public String addStrings(String num1, String num2) {
        int i=num1.length()-1;
        int j=num2.length()-1;
        StringBuilder result=new StringBuilder();
        String s="dafas,asd, edfe, 12312, * & &&&fgffgh";
        String p[]=s.split("\\W+");
        int r=0;
        while(i>=0||j>=0){
            int a=0,b=0;
            if(i>=0&& Pattern.matches("[0-9]]",num1.charAt(i)+"")){
                a=Character.getNumericValue(num1.charAt(i));
            }
            if(j>=0){
                b=Character.getNumericValue(num2.charAt(j));
            }
            int sum=a+b+r;
            r=sum/10;
            result.append(sum%10);
            i--;
            j--;
        }
        if(r>0)result.append(r);
        return result.reverse().toString();
    }
}
