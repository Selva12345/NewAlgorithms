package com.sample;

public class NumberofMusicPlaylists {
	public static void main(String[] args) {
		NumberofMusicPlaylists n = new NumberofMusicPlaylists();
		String s="dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir";
		String sp[]=s.split("\n");
		System.out.println(s);
		System.out.println(n.numMusicPlaylists(2, 4	,1));
		
	}

	long mod = (long) 1000000007;
	Long dp[][];
	int N, L, K;

	public int numMusicPlaylists(int N, int L, int K) {
		dp = new Long[109][109];
		this.N = N;
		this.K = K;
		this.L = L;
		long r = solver(0, 0);

		
		return (int) r;
	}

	private long solver(int len, int num) {
		if (len == L) {
			if (num == N) {
				return 1;
			}

			return 0;	
		}
		if (dp[len][num] != null) {
			return dp[len][num];
		}
		long ans=0;
		ans += (solver(len + 1, num + 1) * (N - num)) % mod;
		 ans+= (solver(len + 1, num) * Math.max(0, num - K)) % mod;
		
		return dp[len][num] = ans;
	}
}
