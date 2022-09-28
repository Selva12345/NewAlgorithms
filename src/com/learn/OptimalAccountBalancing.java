package com.learn;

import java.util.ArrayList;
import java.util.List;

public class OptimalAccountBalancing {
    public static void main(String[] args) {
        OptimalAccountBalancing op=new OptimalAccountBalancing();
        int[][]arr={{0,6,7},{0,7,7},{1,4,5},{1,5,4},{2,5,2},{3,7,1}};
        System.out.println(op.minTransfers(arr));
    }
    public int minTransfers(int[][] transactions) {
        int arr[]=new int[12];
        int n=transactions.length;
        for(int i=0;i<n;i++){
            int temp[]=transactions[i];
            arr[temp[0]]-=temp[2];
            arr[temp[1]]+=temp[2];
        }
        //0=-2 1=5 2=-2 3=1 4=-2
        List<Integer> ct1=new ArrayList<>();
        List<Integer> ct2=new ArrayList<>();
        for(int i=0;i<12;i++){
            if(arr[i]>0){
                ct1.add(arr[i]);
            }
            if(arr[i]<0){
                ct2.add(arr[i]);
            }
        }


        settle(ct1,ct2,0,0,0,0,0,0);
        return min;
    }
    int min=Integer.MAX_VALUE;
    public void settle(List<Integer> ct1, List<Integer> ct2,int p,int m,int v1,int v2,int count,int len){
        if(p==0&& m==0 &&len==(ct1.size()+ct2.size())){
            min=Math.min(min,count);
            return;
        }
        if(p==0&&m==0){
            for(int i=0;i<ct1.size();i++){
                if((1&(v1>>i))==1)continue;

                for(int j=0;j<ct2.size();j++){
                    if((1&(v2>>j))==1)continue;

                    v1=v1^(1<<i);
                    v2=v2^(1<<j);
                    int a=ct1.get(i)+ct2.get(j);
                    settle(ct1,ct2,a>0?a:0,a<0?a:0,v1,v2,count+1,len+2);
                    v1=v1^(1<<i);
                    v2=v2^(1<<j);
                }
            }
        }
        else if(p==0){
            for(int i=0;i<ct1.size();i++){
                if((1&(v1>>i))==1)continue;
                v1=v1^(1<<i);
                int a=ct1.get(i)+m;
                settle(ct1,ct2,a>0?a:0,a<0?a:0,v1,v2,count+1,len+1);
                v1=v1^(1<<i);
            }
        }
        else if(m==0){
            for(int i=0;i<ct2.size();i++){
                if((1&(v2>>i))==1)continue;
                v2=v2^(1<<i);
                int a=p+ct2.get(i);
                settle(ct1,ct2,a>0?a:0,a<0?a:0,v1,v2,count+1,len+1);
                v2=v2^(1<<i);
            }
        }
    }
}
