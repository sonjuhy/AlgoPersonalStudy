package backjoon;

import java.io.*;
import java.util.*;

public class BJ_14503 {

	static int[][] room;
	static int[] delta_x = {0,1,0,-1}, delta_y = {-1,0,1,0};
	static int dir = -1, answer = 0;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		sub();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		room = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken()); // 1 : north 2 : east 3 : south 4 : west
		
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0;m<M;m++) {
				room[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		calc(N,M,R,C);
		System.out.println(answer);
	}
	static void calc(int N, int M, int R, int C) {
		/* 
		 * 1. 현재 칸 청소 (청소 해야할 경우)
		 * 2. 주변 4칸 청소 안되어 있을 경우
		 * 2-1. 반시계 방향으로 회전 후 앞 체크
		 * 2-2. 청소 해야할 경우 전진 후 청소
		 * 3. 싹다 청소 되어있을 경우
		 * 3-1. 뒤로 후진
		 * 3-2. 불가능 시 스탑
		 * */
		int y=R, x=C;
		while(true) {
			if(x == 4 && y == 5) {
				System.out.println("here!");
			}
			if(room[y][x] == 0) {
				room[y][x] = 2;
				answer++;
			}
			else {
				boolean cleaning = true;
				for(int d=3;d>=0;d--) {
					int dx = x + delta_x[(d+dir)%4];
					int dy = y + delta_y[(d+dir)%4];
					if(dx >= M || dx < 0 || dy < 0 || dy >= N) continue;
					if(room[dy][dx] == 1 || room[dy][dx] == 2) continue;
					x = dx;
					y = dy;
					dir = (dir+d)%4;
					cleaning = false;
					break;
				}
				if(cleaning) {
					int dx = x + delta_x[(2+dir)%4];
					int dy = y + delta_y[(2+dir)%4];
					if(dx >= M || dx < 0 || dy < 0 || dy >= N || room[dy][dx] == 1) {
						break;
					}
					x = dx;
					y = dy;
				}
			}
		}
	}
}
