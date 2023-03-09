package backjoon;

import java.io.*;
import java.util.*;

public class BJ_13458 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] A = new long[N];
		
		for(int n=0;n<N;n++) {
			A[n] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		long B = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());
		
		long answer = 0;
		for(int n=0;n<N;n++) {
			answer++;
			if(A[n] > B){
				if((A[n] - B) % C > 0) answer++;
				answer += (A[n] - B) / C;
			}
		}
		System.out.println(answer);
	}

}
