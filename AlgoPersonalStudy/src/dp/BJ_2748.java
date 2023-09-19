package dp;

import java.io.*;

public class BJ_2748 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N+1];
		if(N >= 1) {
			arr[1] = 1;
		}
		long answer = 0;
		for(int n=2;n<=N;n++) {
			arr[n] = arr[n-1] + arr[n-2];
		}
		answer = arr[N];
		System.out.println(answer);
	}

}
