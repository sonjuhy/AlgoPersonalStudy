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
		sub();
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		
//		room = new int[N][M];
//		visited = new boolean[N][M];
//		
//		st = new StringTokenizer(br.readLine());
//		int R = Integer.parseInt(st.nextToken());
//		int C = Integer.parseInt(st.nextToken());
//		dir = Integer.parseInt(st.nextToken());
//		if(dir == 0 || dir == 3) dir -= 1;
//		else dir = 5 - dir;
//		
//		for(int n=0;n<N;n++) {
//			st = new StringTokenizer(br.readLine());
//			for(int m=0;m<M;m++) {
//				room[n][m] = Integer.parseInt(st.nextToken());
//			}
//		}
//		
//		while(true) {
//			/*
//			 * visited != true , answer++
//			 * search delta
//			 *  all visited true , back
//			 *    can't back break
//			 *  visited != true, turn left
//			 *    go
//			 * */
//			if(!visited[C][R] && room[C][R] == 0) {
//				System.out.println("Part.1 : "+R+", "+C);
//				answer++;
//				visited[C][R] = true;
//			}
//			boolean clean = false;
//			for(int i=0;i<4;i++) {
//				int dx = delta_x[i] + R;
//				int dy = delta_y[i] + C;
//				if(dx < 0 || dx >= M || dy < 0 || dy >= N) continue;
//				if(!visited[dy][dx] && room[dy][dx] == 0) {
//					clean = true;
//					break;
//				}
//			}
//			if(clean) {
//				for(int i=0;i<4;i++) {
//					int count = (dir+i+1)%4;
//					int dx = delta_x[count] + R;
//					int dy = delta_y[count] + C;
//					if(dx < 0 || dx >= M || dy < 0 || dy >= N) continue;
//					if(!visited[dy][dx] && room[dy][dx] == 0) {
//						visited[dy][dx] = true;
//						answer++;
//						dir = count;
//						R = dx;
//						C = dy;
//						System.out.println("Part.2 : "+R+", "+C+", dir : "+dir);
//						break;
//					}
//				}
//			}
//			else {
//				int i = Math.abs(2-dir);
//				int dx = delta_x[i] + R;
//				int dy = delta_y[i] + C;
//				if(dx < 0 || dx >= M || dy < 0 || dy >= N) break;
////				if(visited[dy][dx] || room[dy][dx] == 1) break;
//				if(room[dy][dx] == 1) break;
//				if(!visited[dy][dx]) answer++;
//				visited[dy][dx] = true;
//				R = dx;
//				C = dy;
//				System.out.println("Part.3 : "+R+", "+C);
//			}
//		}
//		System.out.println(answer);
	}
	static int n, m, r, c, d;
    static int[][] board;
    static int count = 1; //시작 지점은 항상 청소한다.
    static int[] dx = {-1, 0, 1, 0}; //북, 동, 남, 서 순서대로
    static int[] dy = {0, 1, 0, -1};
    
    public static void sub() {
    	Scanner scan = new Scanner(System.in);
        
        n = scan.nextInt();
        m = scan.nextInt();
        r = scan.nextInt();
        c = scan.nextInt();
        d = scan.nextInt();
        
        board = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                board[i][j] = scan.nextInt();
            }
        }
        
        dfs(r, c, d);
        System.out.println(count);
    }
	public static void dfs(int x, int y, int dir) {
        board[x][y] = 2; //청소 했다는 의미
        
        for(int i = 0; i < 4; i++) {
            dir -= 1; //왼쪽 방향으로 돌면서 탐색
            if(dir == -1) dir = 3;
            
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if(board[nx][ny] == 0) { //벽도 아니고 이미 청소한 곳도 아니라면 청소하러 이동한다
                	System.out.println(x+", "+y+", dir : " + dir);
                    count++;
                    dfs(nx, ny, dir);
                    //일반적인 dfs는 가다가 길이 막히면 다시 되돌아와서 해당 위치부터 계산하지만, 이 문제는 후진할 때만 이전 길을 되돌가 가며 확인할 수 있으므로 return을 해서 다시 되돌아 와도 더 이상 움직이면 안된다.
                    return;
                }
            }
        }
        
        //반목문을 빠져 나왔단는 것은 주변에 더 이상 청소할 공간이 없다는 의미이다.
        int d = (dir + 2) % 4; //반대 방향으로 후진하기 위함.
        int bx = x + dx[d];//후진
        int by = y + dy[d];//후진
        if(bx >= 0 && by >= 0 && bx < n && by < m && board[bx][by] != 1) {
            dfs(bx, by, dir); //후진할 때 방향을 유지해야 한다.
        }
    }
}
