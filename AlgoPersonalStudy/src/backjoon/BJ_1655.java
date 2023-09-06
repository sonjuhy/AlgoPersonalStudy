package backjoon;

import java.io.*;
import java.util.*;

public class BJ_1655 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[N];
		Arrays.fill(arr, Integer.MAX_VALUE);
		for(int n=0;n<N;n++) {
			int num = Integer.parseInt(br.readLine());
			arr[n] = num;
			Arrays.sort(arr);
			if((n&1) == 0) {
				sb.append(arr[n/2]+"\n");
			}
			else {
				sb.append(arr[(n-1)/2]+"\n");
			}
		}
		System.out.println(sb.toString());
	}
}
