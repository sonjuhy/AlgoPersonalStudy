package dp;

import java.io.*;

public class BJ_2193 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N < 2) {
			System.out.println(1);
			return;
		}
		long[] arr = new long[N];
		arr[0] = 1;
		arr[1] = 1;
		for(int i=2;i<N;i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		System.out.println(arr[N-1]);
	}

}
