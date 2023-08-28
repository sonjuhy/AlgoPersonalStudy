package backjoon;

import java.io.*;
import java.util.*;

public class BJ_17266 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[M];
		int maxLen = 0;
		for(int m=0;m<M;m++) {			
			arr[m] = Integer.parseInt(st.nextToken());
			if(m>0) maxLen = Math.max(maxLen, arr[m] - arr[m-1]);
		}
		int start = arr[0];
		int end = N-arr[M-1];
		int answer = Math.max(start, end);
		System.out.println(Math.max(answer, Math.round(maxLen/2.0)));
	}

}
