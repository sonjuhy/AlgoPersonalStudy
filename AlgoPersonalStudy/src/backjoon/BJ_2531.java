package backjoon;

import java.io.*;
import java.util.*;

public class BJ_2531 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		int[] dishies = new int[N];
		boolean cuponCheck = true;
		for(int n=0;n<N;n++) {
			dishies[n] = Integer.parseInt(br.readLine());
			if(dishies[n] == c) cuponCheck = false;
		}
		
		for(int n=0;n<N;n++) {
			int overlapCount = 0, repeat = k;
			boolean cupon = true;
			boolean[] overlaps = new boolean[d+1];
			
			for(int r=0;r<repeat;r++) {
				int point = n+r;
				if(point >= N) point -= N;
				if(cupon && dishies[point] == c) {
					cupon = false;
				}
				if(overlaps[dishies[point]]) overlapCount++;
				else overlaps[dishies[point]] = true;
			}
			if(cupon && !cuponCheck) overlapCount--;
			answer = Math.max(k - overlapCount, answer);
		}
		
		if(cuponCheck) answer++;
		System.out.println(answer);
	}
}
