package backjoon;

import java.io.*;

public class BJ_1463 {
	
	static int[] dp;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		
		calc(N);
		calc2(N);
		System.out.println(answer);
		System.out.println(dp[N]);
	}
	static void calc(int N) {
		
		dp[1] = 0;
		for(int i = 2; i<=N; i++) {
			dp[i] = dp[i-1] + 1;
			if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
			if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
		}
		answer = Math.min(answer, dp[N]);
	}
	static int calc2(int N) {
		if(dp[N] == 0) {
			if(N % 6 == 0) {
				dp[N] = Math.min(calc2(N-1), Math.min(calc2(N/3), calc2(N/2))) + 1;
			}
			else if(N % 3 == 0) {
				dp[N] = Math.min(calc2(N/3), calc2(N-1)) + 1;
			}
			else if(N % 2 == 0) {
				dp[N] = Math.min(calc2(N/2), calc2(N - 1)) + 1;
			}
			else {
				dp[N] = calc2(N-1) + 1;
			}
		}
		return dp[N];
	}
}
