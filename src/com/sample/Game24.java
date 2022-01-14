package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game24 {
	public static void main(String[] args) {
		Game24 g=new Game24();
		int cards[]= {4,1,8,7};
		System.out.println(g.judgePoint24(cards));
	}
	public boolean judgePoint24(int[] cards) {
        List<Double> res=new ArrayList<>();
        for(int c:cards)res.add((double)c);
        
        return justDoIt(res);
    }
    private boolean justDoIt(List<Double> res){
        if(res.size()==1){
            if(Math.abs(res.get(0)-24)<=0.1){
                return true;
            }
            return false;
        }
        for(int i=0;i<res.size();i++){
            for(int j=0;j<i;j++){
                 List<Double> next=new ArrayList<>();
                double p1=res.get(i),p2=res.get(j);
                next.addAll(Arrays.asList(p1+p2,p1-p2,p2-p1,p1/p2,p2/p1,p1*p2));
                System.out.println(next);
                res.remove(i);
                res.remove(j);
                for(double val:next){
                    res.add(val);
                    if(justDoIt(res))return true;
                    res.remove(res.size()-1);
                }
                res.add(j,p2);
                res.add(i,p1);
               
            }
        }
        return false;
    }
}
