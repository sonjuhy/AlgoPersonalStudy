package backjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_해발고도 {
	static boolean[][] visited;
	static int[][] map;
	static int N, K, Count = 1, 
			max_x=Integer.MIN_VALUE, max_y=Integer.MIN_VALUE, 
			min_x=Integer.MAX_VALUE, min_y=Integer.MAX_VALUE;
	
	static int[] delta_x = { 0, 1, 1, 1, 0,-1,-1,-1};
	static int[] delta_y = { 1, 1, 0,-1,-1,-1, 0, 1};
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
	
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int range = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited = new boolean[N][N];
				max_x = j;
				min_x = j;
				max_y = i;
				min_y = i;
				DFS(0,j,i,map[i][j],map[i][j]);
				if(Count == (max_x - min_x)*(max_y - min_y)) {
					range = Math.max(range, Count);
					Count = 1;
				}
			}
		}
		System.out.println(range);
	}
	static void DFS(int dp, int x, int y, int min, int max) {
		if(dp == N*N) {
			return;
		}
		visited[y][x] = true;
		for (int i = 0; i < 8; i++) {
			int dx = x + delta_x[i];
			int dy = y + delta_y[i];
			if(dx < 0 || dx >= N || dy < 0 || dy >=N || visited[dy][dx]) continue;
			int tmp_count = Count;
			if(map[dy][dx] > max) {
				if(map[dy][dx] <= min + K) {
					Count++;
					max = map[dy][dx];
					checkXY(dx, dy);
				}
			}
			else if(map[dy][dx] < min){
				if(map[dy][dx] >= max - K) {
					Count++;
					min = map[dy][dx];
					checkXY(dx, dy);
				}
			}
			else {
				Count++;
				checkXY(dx, dy);
			}
			if(tmp_count != Count) DFS(dp+1, dx, dy, min, max);
		}
	}
	static void checkXY(int x, int y) {
		if(x > max_x) {
			max_x = x;
		} else if(x < min_x) {
			min_x = x;
		}
		
		if(y > max_y) {
			max_y = y;
		} else if(y < min_y) {
			min_y = y;
		}
	}
}
