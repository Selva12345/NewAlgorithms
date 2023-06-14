package com.learn;

public class MinimumWindowSubsequence {
    public static void main(String[] args) {
        MinimumWindowSubsequence m=new MinimumWindowSubsequence();
        m.minWindow("abcdebdde","bde");
    }
    public String minWindow(String s1, String s2) {
        int arr[]=new int[26];
        for(int i=0;i<s2.length();i++){
            char c=s2.charAt(i);
            arr[c-'a']++;
        }
        int next[]=new int[26];
        int j=0,i=0,ans=Integer.MAX_VALUE,initial=-1;
        int count=0,n=s2.length(),start=0;
        for(i=0;i<s1.length();i++){
            next[s1.charAt(i)-'a']++;
            if(s1.charAt(i)==s2.charAt(j)){
                count++;
                j++;
            }
            if(count==n){
                while(start<i){
                    if(s2.charAt(0)!=s1.charAt(start)){
                        start++;
                    }else break;
                }
                int len=i-start+1;
                if(len<ans){
                    initial=start;
                    ans=len;
                }
                StringBuilder sb =new StringBuilder();
                int t=1;
                start++;
                while(start<i&&s2.charAt(0)!=s1.charAt(start)){
                    if(s2.charAt(t)==s1.charAt(start)){
                        sb.append(s2.charAt(t)+"");
                        count--;
                        t++;
                    }
                    start++;
                }
                t=0;
                while(start<i&&sb.length()>t){
                    if(sb.charAt(t)==s1.charAt(start)){
                        t++;

                    }
                    start++;
                }
                j=t;

            }
        }
        if(ans==Integer.MAX_VALUE)return "";
        return s1.substring(initial,initial+ans);
    }
}
