package dp;

import java.io.*;

public class BJ_9461 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			long[] arr = new long[N+3];
			arr[0] = 1;
			arr[1] = 1;
			arr[2] = 1;
			for(int n=0;n<N;n++) {
				arr[n+3] = arr[n] + arr[n+1];	
			}
			System.out.println(arr[N-1]);
		}
	}

}
