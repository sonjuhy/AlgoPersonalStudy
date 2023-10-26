package dp;

import java.io.*;

public class BJ_1904 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		arr[0] = 1;
		arr[1] = 1;
		if(N == 1) System.out.println(1);
		else {
			for(int n=2;n<=N;n++) {
				arr[n] = (arr[n-1] + arr[n-2])%15746;
			}
			System.out.println(arr[N]%15746);
		}
	}

}
