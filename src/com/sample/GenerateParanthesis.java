package com.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParanthesis {
		public static void main(String[] args) {
			GenerateParanthesis g=new GenerateParanthesis();
			g.generateParenthesis(3);
			Stack<Integer> st=new Stack<>();
			
		}
		 public List<String> generateParenthesis(int n) {
	         List<String>  res=new ArrayList<>();
	        
	        generate(n,res,"",0,0);
	        return res;
	    }
	    public void generate(int n, List<String>  res,String s,int t1,int t2){
	       
	    	if(s.length()==n*2){
	    		res.add(s);
	    		return ;
	    	}
	        if(t1<n) {
	        	generate(n,res,s+"(",t1+1,t2);
	        }
	        
	        if(t2<t1) {
	        	generate(n,res,s+")",t1,t2+1);
	        }
	        
	    }
}
