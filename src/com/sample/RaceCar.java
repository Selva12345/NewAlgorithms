package com.sample;

import java.util.Arrays;

public class RaceCar {
	public static void main(String[] args) {
		RaceCar r = new RaceCar();
		System.out.println(r.racecar(6));
	}

	public int racecar(int target) 
    {
        int[] f = new int[1 + target];
        Arrays.fill(f, -1);
        f[0] = 0;
        
        return find(f, target);
    }
    
    int find(int[] f, int i)
    {
        if (f[i] >= 0) return f[i];
        
        f[i] = Integer.MAX_VALUE;
        
        int m = 1;
        for (; dist(m) < i; ++m)
        {
            for (int j = 0; j < m; ++j)
            {
                f[i] = Math.min(f[i], m + 1 + j + 1 + find(f, i - (dist(m) - dist(j))));
            }
        }
        
        f[i] = Math.min(f[i], dist(m) == i ? m : m + 1 + find(f, dist(m) - i));
        
        return f[i];
    }
    
    // starting from position 0, speed 1.
    // after n command-A, the distance the car could go:
    // 2^n - 1
    int dist(int n)
    {
        return (1 << n) - 1;
    }
}
