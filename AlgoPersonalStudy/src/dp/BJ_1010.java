package dp;

import java.io.*;
import java.util.*;

public class BJ_1010 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if(N == M) {
				sb.append(1+"\n");
				continue;
			}
			long answer = 1;
			for(int n=0;n<N;n++) {
				answer *= (M-n);
				answer /= (1+n);
			}
			sb.append(answer+"\n");
		}
		System.out.println(sb.toString());
	}

}
