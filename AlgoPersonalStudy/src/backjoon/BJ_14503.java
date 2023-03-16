package backjoon;

import java.io.*;
import java.util.*;

public class BJ_14503 {

	static int[][] room;
	static boolean[][] visited;
	static int[] delta_x = {-1,0,1,0}, delta_y = {0,1,0,-1};
	static int dir = -1, answer = 0;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		room = new int[N][M];
		visited = new boolean[N][M];
		
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0;m<M;m++) {
				room[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			/*
			 * visited != true , answer++
			 * search delta
			 *  all visited true , back
			 *    can't back break
			 *  visited != true, turn left
			 *    go
			 * */
//			System.out.println(R+":"+C);
			if(!visited[C][R] && room[C][R] == 0) {
				System.out.println("Part.1 : "+R+", "+C);
				answer++;
				visited[C][R] = true;
			}
			boolean clean = false;
			for(int i=0;i<4;i++) {
				int dx = delta_x[i] + R;
				int dy = delta_y[i] + C;
				if(dx < 0 || dx >= M || dy < 0 || dy >= N) continue;
				if(!visited[dy][dx] && room[dy][dx] == 0) {
					clean = true;
					break;
				}
			}
			if(clean) {
				for(int i=0;i<4;i++) {
					int count = (dir+i)%4;
					int dx = delta_x[count] + R;
					int dy = delta_y[count] + C;
					if(dx < 0 || dx >= M || dy < 0 || dy >= N) continue;
					if(!visited[dy][dx] && room[dy][dx] == 0) {
						visited[dy][dx] = true;
						answer++;
						dir = count;
						R = dx;
						C = dy;
						System.out.println("Part.2 : "+R+", "+C+", dir : "+dir);
						break;
					}
				}
			}
			else {
				int i = Math.abs(3-dir);
				int dx = delta_x[i] + R;
				int dy = delta_y[i] + C;
				if(dx < 0 || dx >= M || dy < 0 || dy >= C) break;
				if(visited[dy][dx] || room[dy][dx] == 1) break;
				visited[dy][dx] = true;
				answer++;
				R = dx;
				C = dy;
				System.out.println("Part.3 : "+R+", "+C);
			}
		}
		System.out.println(answer);
	}

}
