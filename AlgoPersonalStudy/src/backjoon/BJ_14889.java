package backjoon;

import java.io.*;
import java.util.*;

public class BJ_14889 {

	static int N, min = Integer.MAX_VALUE;
	static int[] list;
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		list = new int[N/2];
		visited = new boolean[N];
		
		for(int n=0;n<N;n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int m=0;m<N;m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		combi(0,0);
		System.out.println(min);
	}
	static void combi(int deps, int point) {
		if(deps >= N/2) {
			int[] listB = new int[N/2];
			int place = 0, placeB = 0;
			for(int n=0;n<N;n++) {
				if(place < N/2 && list[place] == n) {
					place++;
				}
				else {
					listB[placeB] = n;
					placeB++;
				}
			}
			int sumA = 0, sumB = 0;
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<N/2;j++) {
					sumA += map[list[i]][list[j]];
					sumB += map[listB[i]][listB[j]];
				}
			}
			min = Math.min(min, Math.abs(sumA - sumB));
			return;
		}
		for(int n=point;n<N;n++) {
			if(visited[n]) continue;
			visited[n] = true;
			list[deps] = n;
			combi(deps+1, n+1);
			visited[n] = false;
		}
	}
}
