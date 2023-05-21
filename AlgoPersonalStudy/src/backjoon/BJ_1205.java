package backjoon;

import java.io.*;
import java.util.*;

public class BJ_1205 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		if(N == 0) {
			System.out.println(-1);
			return;
		}
		
		st = new StringTokenizer(br.readLine());
		int before = 0, rank = 0;
		for(int n=0;n<N;n++) {
			if(n >= P) {
				System.out.println(-1);
				break;
			}
			int score = Integer.parseInt(st.nextToken());
			if(score < S) {
				System.out.println(rank);
				break;
			}
			if(before != score) rank++;
			before = score;
		}
	}

}
