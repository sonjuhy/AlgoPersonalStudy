package backjoon;

import java.util.*;
import java.io.*;

public class BJ_1026 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=0;n<N;n++) {
			A[n] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int n=0;n<N;n++) {
			B[n] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		Arrays.sort(B);
		long answer = 0;
		for(int n=0;n<N;n++) {
			answer += A[N-n-1] * B[n];
		}
		System.out.println(answer);
	}

}
