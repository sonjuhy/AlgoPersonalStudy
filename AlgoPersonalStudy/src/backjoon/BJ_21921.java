package backjoon;

import java.util.*;
import java.io.*;

public class BJ_21921 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		
		for(int n=0;n<N;n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		for(int x=0;x<X;x++) {
			sum += arr[x];
		}
		
		int max = sum, count = 1;
		for(int n=1;n<=N-X;n++) {
			sum -= arr[n-1];
			sum += arr[n+X-1];
			
			if(max < sum) {
				max = sum;
				count = 1;
			}
			else if(max == sum) count++;
		}
		if(max == 0) System.out.println("SAD");
		else{
			System.out.println(max);
			System.out.println(count);
		}
	}

}
