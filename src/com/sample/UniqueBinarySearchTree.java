package com.sample;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTree {
	public static void main(String[] args) {
		UniqueBinarySearchTree u = new UniqueBinarySearchTree();
		u.generateTrees(3);

	}

	public List<TreeNode> generateTrees(int n) {
	       return uniqueBinaryTrees(1,n);
	        
	    }
	    public List<TreeNode> uniqueBinaryTrees(int start,int end){
	    
	        if(start>=end){
	            List<TreeNode> dup=new ArrayList<>();
	           dup.add(new TreeNode(start));
	            return dup;
	        }
	        List<TreeNode> result=new ArrayList<>();
	        for(int i=start;i<end;i++){
	           List<TreeNode> left=uniqueBinaryTrees(start,i);
	           List<TreeNode> right=uniqueBinaryTrees(i+1,end);
	            for(TreeNode m:right){
	                for(TreeNode n:left){
	                    m.left=n;
	                    n.right=new TreeNode(m.val);  
	                    result.add(m);
	                    result.add(n);
	                }
	            }
	        }
	        return result;
	    }
	
}
