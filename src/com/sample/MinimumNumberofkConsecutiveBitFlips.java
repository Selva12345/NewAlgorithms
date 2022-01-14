package com.sample;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumNumberofkConsecutiveBitFlips {
	public static void main(String[] args) {
		MinimumNumberofkConsecutiveBitFlips m = new MinimumNumberofkConsecutiveBitFlips();
	//	[0,1,0,0,1,0]
	//			4
		System.out.println(m.minKBitFlips(new int[] { 0,1,0,0,1,0}, 4));
	}

	public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        Queue<Integer> fq = new LinkedList<>();
        int res = 0;
        
        for(int i=0; i<n; i++) {
            if ((A[i] == 0 && fq.size()%2 == 0) || (A[i]==1 && fq.size()%2 == 1)) {
                res++;
                if (i+K > n) return -1;
                fq.add(i+K-1);
            } //fi
            if (fq.size() > 0 && fq.peek() == i) {
                fq.remove();
            }
        }//for
        return res;
    }
}
