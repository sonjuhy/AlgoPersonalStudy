package backjoon;

import java.io.*;
import java.util.*;

public class BJ_21758 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] prefixSum = new int[N+1];
		for(int n=1;n<=N;n++) {
			prefixSum[n] = prefixSum[n-1] + Integer.parseInt(st.nextToken());
		}
		long max = 0;
		for(int n=2;n<=N-1;n++) {
			
			
		}
		for(int n=1;n<=N-1;n++) {
					
					
		}
		for(int n=0;n<N;n++) {
			
			
		}
	}

}
