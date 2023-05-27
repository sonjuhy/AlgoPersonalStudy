package backjoon;

import java.util.*;
import java.io.*;

public class BJ_2169 {

	static int[] delta_x = {1,0,-1};
	static int[] delta_y = {0,1,0};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int[][] values = new int[N][M];
		
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0;m<M;m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0,0});
		while(!queue.isEmpty()) {
			int qSize = queue.size();
			for(int i=0;i<qSize;i++) {
				int[] data = queue.poll();
				values[data[0]][data[1]] += map[data[0]][data[1]];
				for(int d=0;d<3;d++) {
					int dy = data[0];
					int dx = data[1];
					if(dx < 0 || dx >= M || dy < 0 || dy >= N) continue;
					
				}
			}
		}
	}

}
