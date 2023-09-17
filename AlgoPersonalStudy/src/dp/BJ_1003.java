package dp;

import java.io.*;

public class BJ_1003 {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<T;t++){
			int N = Integer.parseInt(br.readLine());
			int[] arr1 = new int[N+1];
			int[] arr2 = new int[N+2];
			arr1[0] = 1;
			arr2[0] = 0;
			if(N >= 1) {
				arr1[1] = 0;
				arr2[1] = 1;
			}
			for(int n=2;n<=N;n++) {
				arr1[n] = arr1[n-1] + arr1[n-2];
				arr2[n] = arr2[n-1] + arr2[n-2];
			}
			sb.append(arr1[N] + " " + arr2[N]+"\n");
		}
		System.out.println(sb);
	}
	
}
