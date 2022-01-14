package com.sample;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
	public static void main(String[] args)

	{
		int mat[][] = 
			  { { 1, 0, 1, 1, 0, 0, 1, 0, 0, 1 }, 
				{ 0, 1, 1, 0, 1, 0, 1, 0, 1, 1 },
				{ 0, 0, 1, 0, 1, 0, 0, 1, 0, 0 }, 
				{ 1, 0, 1, 0, 1, 1, 1, 1, 1, 1 }, 
				{ 0, 1, 0, 1, 1, 0, 0, 0, 0, 1 },
				{ 0, 0, 1, 0, 1, 1, 1, 0, 1, 0 }, 
				{ 0, 1, 0, 1, 0, 1, 0, 0, 1, 1 }, 
				{ 1, 0, 0, 0, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 0, 1, 0 }, 
				{ 1, 1, 1, 1, 0, 1, 0, 0, 1, 1 } };
		ZeroOneMatrix z=new ZeroOneMatrix();
		System.out.println(z.updateMatrix(mat));
		
	}

	  public int[][] updateMatrix(int[][] mat) {
	        int n=mat.length;
	        int m=mat[0].length;
	        int dp[][]=new int[n][m];
	        for(int a[]:dp)Arrays.fill(a,Integer.MAX_VALUE);
	        int x[] = { -1, 0, 1, 0 };
		    int y[] = { 0, 1, 0, -1 };
	        Queue<int[]> q=new LinkedList<>();
	        for(int i=0;i<n;i++){
	            for(int j=0;j<m;j++){
	                if(mat[i][j]==0){
	                    dp[i][j]=0;
	                    continue;
	                }
	                q.offer(new int[]{i,j,0});
	                boolean visited[][]=new boolean[n][m];
	                visited[i][j]=true;
	                while(!q.isEmpty()){
	                    int val[]=q.poll();
	                   
	                    if(mat[val[0]][val[1]]==0){
	                        dp[i][j]=val[2];
	                        break;
	                    }
	                     if(dp[val[0]][val[1]]!=Integer.MAX_VALUE){
	                        dp[i][j]=val[2]+dp[val[0]][val[1]];
	                       continue;
	                    }
	                    for(int k=0;k<4;k++){
	                       int t = x[k] + val[0];
				           int u = y[k] + val[1];
				         if (isSafe(t, u, mat.length, mat[0].length) && !visited[t][u]) {
					         visited[t][u] = true;
	                         q.offer(new int[]{t,u,val[2]+1});
				           }
	                    }
	                }
	            }
	        }
	        return dp;
	    }
	    private boolean isSafe(int i, int j, int n, int m) {
			if (i >= 0 && i < n && j >= 0 && j < m) {
				return true;
			}
			return false;
		}
}
