package backjoon;

import java.io.*;
import java.util.*;

public class BJ_17484 {
	static int answer = Integer.MAX_VALUE, N=0, M=0;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0;m<M;m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		for(int m=0;m<M;m++) {
			calc(0,m,-10,0);
		}
		System.out.println(answer);
	}
	static void calc(int deps,int point, int order, int sum) {
		if(deps >= N) {
			answer = Math.min(answer, sum);
			return;
		}
		for(int m=-1;m<2;m++) {
			if(m == order) continue;
			int des = m + point;
			if(des < 0 || des >= M) continue;
			calc(deps+1, des, m, sum+map[deps][des]);
		}
	}
}
