package backjoon;

import java.io.*;
import java.util.*;

public class BJ_2589 {
	static int answer = 0,L,W;
	static char[][] map;
	static boolean[][] visited;
	
	static int[] delta_x = {0,1,0,-1,0};
	static int[] delta_y = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new char[L][W];
		
		for(int l=0;l<L;l++) {
			map[l] = br.readLine().toCharArray();
		}
		for(int l=0;l<L;l++) {
			for(int w=0;w<W;w++) {
				if(map[l][w] == 'W') continue;
				visited = new boolean[L][W];
				BFS(l, w);
			}
		}
		System.out.println(answer);
	}
	static void BFS(int l, int w) {
		Queue<int[]> queue = new LinkedList<>();
		visited[l][w] = true;
		int val = 0;
		queue.add(new int[]{l,w,0});
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			for(int i=0;i<4;i++) {
				int dx = delta_x[i] + q[1];
				int dy = delta_y[i] + q[0];
				if(dx < 0 || dx >= W || dy < 0 || dy >= L || visited[dy][dx] || map[dy][dx] == 'W') continue;
				visited[dy][dx] = true;
				queue.add(new int[] {dy,dx,q[2]+1});
				val = Math.max(val, q[2]+1);
			}
		}
		answer = Math.max(val, answer);
	}
}
