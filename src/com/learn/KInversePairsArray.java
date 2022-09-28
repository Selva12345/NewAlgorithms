package com.learn;

public class KInversePairsArray {
    public static void main(String[] args) {
        KInversePairsArray m=new KInversePairsArray();
        System.out.println(m.kInversePairs(5,3));
    }
    public int kInversePairs(int n, int k) {
        int dp[]=new int[k];
        return inverseArrays(n,k);
    }
    public int inverseArrays(int n,int k){
        if(k<0){
            return 0;
        }
        if(k==0){
            return 1;
        }
        if(n==0){
            return 0;
        }
        int count=0;
        for(int i=2;i<=n;i++){
            int s = ((i-1)*i)/2;
            for(int j=i-1;j<n;j++){
                count+=inverseArrays(n-i,k-s);
            }
        }
        return count;
    }
}
