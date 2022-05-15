package com.learn;

import java.util.*;

public class SubstringwithConcatenationofAllWords {
    public static void main(String[] args) {
        SubstringwithConcatenationofAllWords s=new SubstringwithConcatenationofAllWords();
        String sr="barfoofoobarthefoobarman";
        String []str={"bar","foo","the"};
        System.out.println(s.findSubstring(sr,str));
    }
    public List<Integer> findSubstring(String s, String[] words) {
        int n=words.length;
        int m=words[0].length();
        Random r=new Random();
        Map<String,Integer> values=new HashMap<>();
        for(int i=0;i<words.length;i++){
            values.put(words[i],values.getOrDefault(words[i],0)+1);
        }
        List<Integer> result=new ArrayList<>();
        int t=n*m;
        int i=0;
        for(;i<s.length();){
            int p=i+t;
            boolean c=false;
            Map<String,Integer> temp=new HashMap<>(values);
            int j=i;
            if(p>s.length()){
                break;
            }
            for(;j<=p-m&&p<=s.length();){
                String st=s.substring(j,j+m);
                if(temp.containsKey(st)&&temp.get(st)>0){
                    temp.put(st,temp.get(st)-1);
                    j+=m;
                    continue;
                }
                c=true;
                break;

            }
            if(!c) {
                result.add(i);
            }
               i++;
        }
        return result;
    }
}
