package com.learn;

import java.util.Arrays;

public class LongestLineOfConsecutiveOneInMatrix {
    public static void main(String[] args) {
        LongestLineOfConsecutiveOneInMatrix l=new LongestLineOfConsecutiveOneInMatrix();
        int mat[][]={{0,1,1,0},{0,1,1,0},{0,0,0,1}};
        System.out.println(l.longestLine(mat));
    }
    public int longestLine(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int dp1[][]=new int[n][m];
        int dp2[][]=new int[n][m];
        int dp3[][]=new int[n][m];
        int dp4[][]=new int[n][m];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        Arrays.fill(dp3,-1);
        Arrays.fill(dp4,-1);
        boolean visited[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int res=0;
                if(mat[i][j]==1){
                    res= longestLines(mat,i,j,visited,n,m,0,2,dp1);
                    res= longestLines(mat,i,j,visited,n,m,2,4,dp2);
                    res= longestLines(mat,i,j,visited,n,m,4,6,dp3);
                    res= longestLines(mat,i,j,visited,n,m,6,8,dp4);
                }

            }
        }
        return 0;
    }
    int x[]={ 0, 0,-1, 1, -1,  1, 1, -1};
    int y[]={-1, 1, 0, 0,  1, -1, 1, -1};
    public int longestLines(int[][] mat,int i,int j,boolean visited[][],int n,int m,int start,int end,int dp[][]){
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int res=0;
        for(int k=start;k<end;k++){
            int a=x[k]+i;
            int b=y[k]+j;
            int ans =0;
            if(isSafe(a,b,n,m)&&mat[a][b]==1&& !visited[a][b]){
                ans=longestLines(mat,a,b,visited,n,m,start,end,dp);
            }

        }
        return res;
    }
    public boolean isSafe(int i,int j,int n,int m){
        if(i>=0&&j>=0&&j<m&&i<n){
            return true;
        }
        return false;
    }
}
