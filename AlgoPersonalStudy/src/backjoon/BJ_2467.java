package backjoon;

import java.io.*;
import java.util.*;

public class BJ_2467 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] arr = new long[N];
		for(int n=0;n<N;n++) {
			arr[n] = Long.parseLong(st.nextToken());
		}
		
		long[] pair = new long[2];
		long sum = Long.MAX_VALUE;
		int start = 0, end = N-1;
		
		while(start < end) {
			if(Math.abs(arr[start] + arr[end]) < Math.abs(sum)) {
				pair[0] = arr[start];
				pair[1] = arr[end];
				sum = arr[start] + arr[end];
			}
			if(sum >= 0) end--;
			else start++;
			
		}
		
//		while(start < end) {
//			long tmp = arr[start] + arr[end];
//			if(Math.abs(tmp) < sum) {
//				pair[0] = arr[start];
//				pair[1] = arr[end];
//				sum = Math.abs(tmp);
//			}
//			if(sum >= 0) end--;
//			else start++;
//			
//		}
		System.out.println(pair[0]+" "+pair[1]);
	}

}
