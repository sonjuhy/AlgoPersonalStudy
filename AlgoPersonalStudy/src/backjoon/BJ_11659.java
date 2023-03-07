package backjoon;

import java.io.*;
import java.util.*;

public class BJ_11659 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int n=0;n<N;n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int sum = 0;
		int[] prefixSum = new int[N+1];
		for(int n=1;n<=N;n++) {
			sum += arr[n-1];
			prefixSum[n] = sum;
		}
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if(start == end) start = end - 1;
			else start -= 1;
			int answer = prefixSum[end]-prefixSum[start];
			bw.write(answer+"\n");
		}
		bw.flush();
		bw.close();
		
	}

}
