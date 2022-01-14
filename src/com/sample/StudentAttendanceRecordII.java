package com.sample;

import java.util.Arrays;

public class StudentAttendanceRecordII {
	public static void main(String[] args) {
		StudentAttendanceRecordII s=new StudentAttendanceRecordII();
		System.out.println(s.checkRecord(2));
	}

	 long mod=(long)(Math.pow(10,9)+7);
	    Long dp[][][][];
	    public int checkRecord(int n) {
	        String s="PLA";
	        s.hashCode();
	        dp=new Long[n+1][n+1][3][2];
	        long value=justDoIt(s,n,0,0,0,new StringBuilder());
	        return (int)(value%mod);
	    }
	    private long justDoIt(String s,int n,int p,int l,int a,StringBuilder sb){
	        
	        if(n<=0){
	            return 1L;
	        }
	        System.out.println(n+" "+p+" "+a);
	        if(dp[n][p][l][a]!=null){
	            return  dp[n][p][l][a];
	        }
	        long value=0;
	        for(int i=0;i<3;i++){
	            if(s.charAt(i)=='A'&&a<=0){
	             value+=justDoIt(s,n-1,p,0,a+1,sb)%mod; 
	            }else if(s.charAt(i)=='L'&&l<=3){
	              value+=justDoIt(s,n-1,p,l+1,a,sb)%mod;  
	            }else if(s.charAt(i)=='P'){
	                //sb.append(s.charAt(i)+"");
	              value+=justDoIt(s,n-1,p+1,0,a,sb)%mod; 
	               // sb.deleteCharAt(sb.lengtth()-1);
	            }
	            
	        }
	        dp[n][p][l][a]=value;
	        return value;
	    }
}
