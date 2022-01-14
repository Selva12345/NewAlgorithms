package com.sample;

import java.util.Arrays;

public class HouseRobberIII {
	public static void main(String[] args) {
		HouseRobberIII h=new HouseRobberIII();
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(4);
		root.left.right=new TreeNode(3);
		root.left.left=new TreeNode(1);
		root.right=new TreeNode(5);
		root.right.right=new TreeNode(1);
		System.out.println(h.rob(root));
	}

	 Integer dp[][][];
	    public int rob(TreeNode root) {
	        dp=new Integer[5001][5001][2];
	       return robber(root);
	    }
	    private int  robber(TreeNode root){
	        return justDoIt(root,0,0,0);
	    }
	    private int justDoIt(TreeNode root,int flag,int l,int r){
	        if(root==null){
	            return 0;
	        }
	       
	        if(dp[l][r][flag]!=null){
	            return dp[l][r][flag];
	        }
	       
	        int m=0;
	        if(flag==0){
	          m=Math.max(justDoIt(root.left,1,l+1,r)+justDoIt(root.right,1,l,r+1)+root.val,m);
	        }
	          m=Math.max(justDoIt(root.left,0,l+1,r)+justDoIt(root.right,0,l,r+1),m);
	          dp[l][r][flag]=m;
	        return m;
	    }
}
