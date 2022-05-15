package com.learn;

import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        AlienDictionary alienDictionary=new AlienDictionary();
        //new String[]{"wrt","wrf","er","ett","rftt"}
        System.out.println(alienDictionary.alienOrder(new String[]{"ac","ab","zc","zb"}));
    }
    public String alienOrder(String[] words) {
        Map<Character,Set<Character>> adj=new HashMap<>();
        for(int i=1;i<words.length;i++){
            String str1=words[i-1];
            String str2=words[i];
            int j=0,n=str1.length(),m=str2.length();
            for(;j<Math.min(n,m);j++){
                if(!adj.containsKey(str1.charAt(j))){
                    Set<Character> temp=new HashSet<>();
                    adj.put(str1.charAt(j),temp);
                }
                if(!adj.containsKey(str2.charAt(j))){
                    Set<Character> temp=new HashSet<>();
                    adj.put(str2.charAt(j),temp);
                }
                if(str1.charAt(j)==str2.charAt(j))continue;

                    Set<Character> temp=adj.get(str1.charAt(j));
                    temp.add(str2.charAt(j));
                    adj.put(str1.charAt(j),temp);
                    break;
            }
            for(;j<n;j++){
                if(!adj.containsKey(str1.charAt(j))){
                    Set<Character> temp=new HashSet<>();
                    adj.put(str1.charAt(j),temp);
                }
            }
            for(;j<m;j++){
                if(!adj.containsKey(str2.charAt(j))){
                    Set<Character> temp=new HashSet<>();
                    adj.put(str2.charAt(j),temp);
                }
            }
        }
        boolean[] visited=new boolean[26];
        StringBuilder sb=new StringBuilder();
        Stack<Character> q=new Stack<>();
        for(char a='a';a<='z';a++){
               int v=a-'a';
               if(visited[v]||!adj.containsKey(a))continue;
               traverse(adj,visited,a,new boolean[26],q);
        }
        while(!q.isEmpty()){
            char p=q.pop();
            sb.append(p+"");
        }
        return sb.toString();
    }
    public boolean traverse(Map<Character, Set<Character>> adj,
                         boolean[] visited, char c, boolean[]stack, Stack<Character> st){
        if(stack[c-'a']){
            return false;
        }
        if(visited[c-'a']){
            return true;
        }
        stack[c-'a']=true;
        visited[c-'a']=true;

        for(Character s:adj.get(c)){
            if(!traverse(adj,visited,s,stack,st)){
                return false;
            }
        }
        st.push(c);
        stack[c-'a']=false;
        return true;
    }
}
