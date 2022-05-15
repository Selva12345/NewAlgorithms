package com.learn;

import java.util.*;

public class MinimumGeneticMutation {
    public static void main(String[] args) {
        MinimumGeneticMutation m=new MinimumGeneticMutation();
        //"AAAACCCC"
        //"CCCCCCCC"
        //["AAAACCCA","AAACCCCA","AACCCCCA","AACCCCCC","ACCCCCCC","CCCCCCCC","AAACCCCC","AACCCCCC"]
        System.out.println(m.minMutation("AAAACCCC","CCCCCCCC",
                new String[]{"AAAACCCA","AAACCCCA","AACCCCCA","AACCCCCC","ACCCCCCC","CCCCCCCC","AAACCCCC","AACCCCCC"}));
    }
    public int minMutation(String start, String end, String[] bank) {
        Set<String> visited=new HashSet<>();
        Map<String,List<String>> graph=new HashMap<>();
        if(start.equals(end)){
            return 0;
        }
        visited.add(start);
        int result= minimumSteps(start,end,bank,graph,"",visited);
        if(result==Integer.MAX_VALUE){
            return -1;
        }
        return result;

    }
    public int minimumSteps(String start, String end, String[] bank, Map<String, List<String>> graph, String parent,
                            Set<String> visited){
        buildGraph(start,end,bank,graph,parent);
        if(start.equals(end)){
            return 0;
        }
        if(graph.get(start)==null){
            return Integer.MAX_VALUE;
        }
        int min=Integer.MAX_VALUE;
        for(String st:graph.get(start)){
            if(visited.contains(st))continue;
            visited.add(st);
            int value=minimumSteps(st,end,bank,graph,start, visited);
            visited.remove(st);
            if(value== Integer.MAX_VALUE){
                continue;
            }else{
                min=Math.min(value,min)+1;
            }

        }
        return min;
    }
    public void buildGraph(String start,String end,String[]bank, Map<String,List<String>> graph,String parent){
        List<String> change=new ArrayList<>();
        for(int i=0;i<bank.length;i++){
            int count=0;
            for(int j=0;j<start.length();j++){
                if(start.charAt(j)!=bank[i].charAt(j)){
                    count++;
                }
            }
            if(count==1&&!bank[i].equals(parent)){
                change.add(bank[i]);
                graph.put(start,change);
            }
        }

    }
}
