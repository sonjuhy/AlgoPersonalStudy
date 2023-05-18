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
		
		int[] dishies = new int[N];
		int[] overlaps = new int[N];
		boolean cuponCheck = true;
		for(int n=0;n<N;n++) {
			dishies[n] = Integer.parseInt(br.readLine());
			if(dishies[n] == c) cuponCheck = false;
		}
		
		for(int n=0;n<N;n++) {
			int overlapCount = 0, repeat = k;
			boolean cupon = true;
			HashMap<Integer, Integer> hashMap = new HashMap<>();
			for(int r=0;r<repeat;r++) {
				int point = n+r;
				if(point >= N) point -= N;
				if(dishies[point] == c && cupon && (r == 0 || r == repeat-1)) {
					repeat++;
					overlapCount--;
					cupon = false;
				}
				if(hashMap.containsKey(dishies[point])) overlapCount++;
				else hashMap.put(dishies[point], 1);
			}
			overlaps[n] = k - overlapCount;
		}
		
		int answer = overlaps[0];
		for(int n=1;n<N;n++) answer = Math.max(answer, overlaps[n]);
		if(cuponCheck) answer++;
		System.out.println(answer);
	}
}
