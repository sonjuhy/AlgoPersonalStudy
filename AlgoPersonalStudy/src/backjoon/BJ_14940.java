package backjoon;

import java.io.*;
import java.util.*;

public class BJ_14940 {
	
	static int[] delta_x = {0,1,0,-1};
	static int[] delta_y = {1,0,-1,0};

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int[][] answer = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		
		int[] startPoint = new int[2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int point = Integer.parseInt(st.nextToken());
				map[i][j] = point;
				if(point == 2) {
					startPoint[0] = i;
					startPoint[1] = j;
				}
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.add(startPoint);
		visited[startPoint[0]][startPoint[1]] = true;
		int count = 0;
		
		while(!queue.isEmpty()) {
			
			count++;
			int queueSize = queue.size();
			
			for(int q=0;q<queueSize;q++) {
				int[] point = queue.poll();
				for(int d=0;d<4;d++) {
					int dx = point[1] + delta_x[d];
					int dy = point[0] + delta_y[d];
					if(dx < 0 || dx >= M || dy < 0 || dy >= N) continue;
					if(visited[dy][dx]) continue;
					if(map[dy][dx] == 0) {
						visited[dy][dx] = true;
						continue;
					}
					answer[dy][dx] = count;
					visited[dy][dx] = true;
					queue.add(new int[] {dy,dx});
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visited[i][j] && map[i][j] != 0) {
					answer[i][j] = -1;
				}
				sb.append(answer[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
