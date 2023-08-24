package backjoon;

import java.io.*;
import java.util.*;

public class BJ_22251 {
	static int[][] map = {
			{0, 4, 3, 2, 4, 3, 2, 3, 1, 2},
			{4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
			{3, 5, 0, 2, 6, 4, 3, 4, 2, 3},
			{2, 3, 2, 0, 3, 2, 3, 2, 2, 1},
			{4, 2, 6, 3, 0, 3, 4, 3, 3, 2},
			{3, 5, 4, 2, 3, 0, 2, 4, 2, 1},
			{2, 6, 3, 3, 4, 2, 0, 5, 1, 2},
			{3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
			{1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
			{2, 4, 3, 1, 2, 1, 2, 3, 1, 0}
	};
	public static void main(String[] args)  throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[] number = new int[K];
		char[] numChar = String.valueOf(X).toCharArray();
		
		for(int i=0;i<K;i++) {
			if(numChar.length <K-i) number[i] = 0;
			else {
				number[i] = numChar[i-(K-numChar.length)] - '0';
			}
		}
		int answer = 0;
		for(int i=1;i<=N;i++) {
			if(i == X) continue;
			int count = 0;
			boolean countCheck = true;
			
			int[] tmpNum = new int[K];
			char[] tmpNumChar = String.valueOf(i).toCharArray();
			for(int k=0;k<K;k++) {
				if(tmpNumChar.length <K-k) tmpNum[k] = 0;
				else {
					tmpNum[k] = tmpNumChar[k-(K-tmpNumChar.length)] - '0';
				}
				
				count += map[number[k]][tmpNum[k]];
				if(count > P) {
					countCheck = false;
					break;
				}
			}
			if(countCheck) {
				answer++;
				System.out.println(i);
			}
		}
		System.out.println(answer);
	}

}
