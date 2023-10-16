package dp;

import java.io.*;

public class BJ_2775_noneDP {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int K = Integer.parseInt(br.readLine());
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			for(int n=0;n<N;n++) arr[n] = n+1;
			for(int k=0;k<K;k++) {
				int[] tmpArr = new int[N];
				for(int n=0;n<N;n++) {
					for(int j=0;j<=n;j++) {
						tmpArr[n] += arr[j];
					}
				}
				arr = tmpArr;
			}
			System.out.println(arr[N-1]);
		}
	}

}
