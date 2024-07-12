package com.learn;

import java.util.HashMap;
import java.util.Map;

public class ExtraOrdinarySubString {
    static Map<Character,Integer> mapped;
    public static void main(String[] args) {
        ExtraOrdinarySubString e=new ExtraOrdinarySubString();
        mapped=new HashMap<>();
        mapped.put('a',1);
        mapped.put('b',1);
        mapped.put('c',2);
        mapped.put('d',2);
        mapped.put('e',2);
        mapped.put('f',3);
        mapped.put('g',3);
        mapped.put('h',3);
        mapped.put('i',4);
        mapped.put('j',4);
        mapped.put('k',4);
        mapped.put('l',5);
        mapped.put('m',5);
        mapped.put('n',5);
        mapped.put('o',6);
        mapped.put('p',6);
        mapped.put('q',6);
        mapped.put('r',7);
        mapped.put('s',7);
        mapped.put('t',7);
        mapped.put('u',8);
        mapped.put('v',8);
        mapped.put('w',8);
        mapped.put('x',9);
        mapped.put('y',9);
        mapped.put('z',9);
        System.out.println("Answer "+e.countSubString("bdh"));
    }

    public int countSubString(String input){
        int count=0;
        int len=input.length();
        count+=len;
        for(int i=0;i<len;i++){

            for(int j=i+1;j<len;j++){
                //i=0,j=1;
                //0,2
               String temp=input.substring(i,j+1);
               if(isExtraordinary(temp)){
                    count++;
               }
            }
        }
        return count;
    }

    private boolean isExtraordinary(String s) {
        int m=0;
        for(int i=0;i<s.length();i++){
            char t=s.charAt(i);
            m+=mapped.get(t);
        }
        if(m%s.length()==0){
            return true;
        }
        return false;
    }
}
