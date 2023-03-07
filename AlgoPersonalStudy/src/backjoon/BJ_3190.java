package backjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3190 {
	static int N, x=0,y=0, dir = 1, time = 1;// dir 0 : 상, 1 : 우, 2 : 하, 3 : 좌
	static int[][] map;
	
	static Queue<int[]> snake = new LinkedList<>();
	
	static int[] dir_x = { 0, 1, 0,-1};
	static int[] dir_y = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st  = null;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			map[y][x] = 1;
		}
		int L = Integer.parseInt(br.readLine());
		map[0][0] = 2;
		snake.offer(new int[] {0,0});
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			boolean check = move(t,c);
			if(!check) {
				System.out.println(time);
				return;
			}
		}
		move(N, 'A');
		System.out.println(time);
	}
	static boolean move(int t, char c) {
		for (int i = 0; i < t; i++) {
			int dx = x + dir_x[dir];
			int dy = y + dir_y[dir];
			if(dx < 0 || dx >= N || dy < 0 || dy >= N) return false;
			if(map[dy][dx] > 1) return false;
			snake.offer(new int[] {dx, dy});
			if(map[dy][dx] == 0) {
				int[] tmp = snake.poll();
				map[tmp[1]][tmp[0]] = 0;
			}
			map[dy][dx] = 2;
			time++;
			x = dx;
			y = dy;
		}
		if(c == 'L') {
			if(dir == 0) dir = 3;
			else dir--;
		}
		else if(c == 'D'){
			if(dir == 3) dir =0;
			else dir++;
		}
		return true;
	}
}
