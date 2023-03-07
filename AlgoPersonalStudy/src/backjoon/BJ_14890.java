package backjoon;

import java.io.*;
import java.util.*;

public class BJ_14890 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		int answer = 0;
		
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			int before = Integer.parseInt(st.nextToken());
			map[n][0] = before;
			boolean pass = true, used = true, checking = false;
			int len = 1, direction = -1; // direction 0 : left, 1 : right
			for(int m=1;m<N;m++) {
				/**
				 * 1. 전칸과 2 이상 차이나면 X
				 * 2. 경사로 쌓아야하는데 전칸이 이미 경사로 있으면 X
				 * 3. 경사로 쌓아야하는데 쌓을 칸이 모자라면 X
				 * */
				map[n][m] = Integer.parseInt(st.nextToken());
				if((int)Math.abs(before - map[n][m]) > 1) pass = false;
				else if(pass){
					if(used) {
						if(before == map[n][m]) {
							len++;
							if(checking && len == L) {
								len = 1;
								checking = false;
								used = false;
							}
						}
						else {
							int diff = before - map[n][m];
							if(diff < 0) {
								if(len < L) {
									pass = false;
									continue;
								}
								else {
									len = 1;
								}
							}
							else if(diff > 0) {
								if(len >= L && L == 1) {
									used = false;
									direction = 0;
									len = 1;
								}
								else {
									if(checking) {
										pass = false;
										continue;
									}
									checking = true;
									len = 1;
								}
							}
							
						}
						if(m == N-1 && checking) pass = false;
					}
					else {
						used = true;
						len = 1;
						int diff = before - map[n][m];
						if(diff < 0 && direction != 1) {
							pass = false;
							continue;
						}
						if(diff != 0 && len == L) {
							used = false;
							if(diff < 0) direction = 1;
							else direction = 0;
						}
						else if(diff > 0 && len < L) {
							checking = true;
						}
						else {
							direction = -1;
						}
						if(m == N-1 && diff != 0 && len != L) pass = false;
					}
					before = map[n][m];
				}
			}
			
			if(pass) {
				answer++;
			}
		}
		answer += calcRow(map, N, L);
		System.out.println(answer);
	}
	public static int calcRow(int[][] map, int N, int L) {
		int answer = 0;
		for(int n=0;n<N;n++) {
			int before = map[0][n];
			boolean pass = true, used = true, checking = false;
			int len = 1, direction = -1; // direction 0 : up, 1 : down
			for(int m=1;m<N;m++) {
				if((int)Math.abs(before - map[m][n]) > 1) pass = false;
				else if(pass){
					if(used) {
						if(before == map[m][n]) {
							len++;
							if(checking && len == L) {
								len = 1;
								checking = false;
								used = false;
							}
						}
						else {
							int diff = before - map[m][n];
							if(diff < 0) {
								if(len < L) {
									pass = false;
								}
								else {
									len = 1;
								}
							}
							else if(diff > 0) {
								if(len >= L && L == 1) {
									used = false;
									direction = 0;
									len = 1;
								}
								else {
									if(checking) {
										pass = false;
										continue;
									}
									checking = true;
									len = 1;
								}
							}
							
						}
						if(m == N-1 && checking) pass = false;
					}
					else {
						used = true;
						len = 1;
						int diff = before - map[m][n];
						if(diff < 0 && direction != 1) {
							pass = false;
							continue;
						}
						if(diff != 0 && len == L) {
							used = false;
							if(diff < 0) direction = 1;
							else direction = 0;
						}
						else direction = -1;
						if(m == N-1 && diff != 0 && len != L) pass = false;
					}
					before = map[m][n];
				}
			}
			
			if(pass) {
				answer++;
			}
		}
		return answer;
	}
}
