package backjoon;

import java.io.*;
import java.util.*;

public class BJ_16234 {

	static boolean moved = false;
	static int N,L,R,answer = 0, deps = 0, sum = 0, count = 1;
	static int[][] map;
	static int[][] visited;
	
	static int[] delta_x = {0,1,0,-1}, delta_y = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			for(int n2=0;n2<N;n2++) {
				map[n][n2] = Integer.parseInt(st.nextToken());
			}
		}
		int search = 0;
		while(true) {
			visited = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(visited[i][j] != 0) continue;
					visited[i][j] = count;
					BFS(j,i);
					move();
					search += deps;
					sum = 0;
					deps = 0;
					count++;
				}
			}
			if(moved) {
				answer++;
				moved = false;
			}
			else break;
		}
		System.out.println(answer);
	}
	static void BFS(int x, int y) {
		
		sum += map[y][x];
		deps++;
		
		for(int d=0;d<4;d++) {
			int dx = x + delta_x[d];
			int dy = y + delta_y[d];
			if(dx < 0 || dx >= N || dy < 0 || dy >= N) continue;
			if(visited[dy][dx] != 0) continue;
			int diff = Math.abs(map[y][x] - map[dy][dx]);
			if(diff > R || diff < L) continue;
			visited[dy][dx] = count;
			moved = true;
			BFS(dx,dy);
		}
	}
	static void move() {
		int people = sum / deps;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j] == count) {
					map[i][j] = people;
				}
			}
		}
	}
}
