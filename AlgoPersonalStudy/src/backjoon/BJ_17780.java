package backjoon;

import java.io.*;
import java.util.*;

public class BJ_17780 {

	static int[] delta_x = {1,-1,0,0}, delta_y = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		int[][] visited = new int[N][N];
		
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0;m<N;m++) {
				map[n][m] = Integer.parseInt(st.nextToken()); // white, red, blue
			}
		}
		
		List<Chess> chessList = new ArrayList<>();
		
		for(int k=0;k<K;k++) {
			st = new StringTokenizer(br.readLine());
			int col = Integer.parseInt(st.nextToken())-1;
			int row = Integer.parseInt(st.nextToken())-1;
			int order = Integer.parseInt(st.nextToken())-1;
			chessList.add(new Chess(row, col, k+1,order));
			visited[row][col] = k+1;
		}
		
		for(int i=0;i<1000;i++) {
			if(chessList.size() == 1) {
				System.out.println(i+1);
				return;
			}
			for(int j=0;j<chessList.size();j++) {
				Chess chess = chessList.get(j);
				int order = chess.order;
				int dx = chess.x + delta_x[order];
				int dy = chess.y + delta_y[order];
				if(dx < 0 || dx >= N || dy < 0 || dy >= N) continue;
				if(visited[dy][dx] == 0) { // no piece
					switch(map[dy][dx]) {
					case 1:
						chess.reverse();
					case 0:
						visited[dy][dx] = chess.num;
						visited[chess.y][chess.x] = 0;
						chess.x = dx;
						chess.y = dy;
						break;
					case 2:
						chess.changeOrder();
						int changeOrder = chess.order;
						int blueX = chess.x + delta_x[changeOrder];
						int blueY = chess.y + delta_y[changeOrder];
						if(!(blueX < 0 || blueX >= N || blueY < 0 || blueY >= N)) {
							if(visited[blueY][blueX] == 0) {
								visited[blueY][blueX] = chess.num;
								visited[chess.y][chess.x] = 0;
								chess.x = blueX;
								chess.y = blueY;
							}
							else {
								Chess origin = null;
								for(int c=0;c<chessList.size();c++) {
									if(chessList.get(c).num == visited[blueY][blueX]) {
										origin = chessList.get(c);
										j--;
										break;
									}
								}
								visited[chess.y][chess.x] = 0;
								origin.put(chess.list);
								chessList.remove(chess);
							}
						}
						break;
					}
				}
				else { // exist piece
					Chess origin = null;
					switch(map[dy][dx]) {
					case 1: // red : list reverse and put
						chess.reverse();
					case 0: // white : put
						for(int c=0;c<chessList.size();c++) {
							System.out.println("line 94 | chess num : " + visited[dy][dx]+", list num : " + chessList.get(c).num);
							if(chessList.get(c).num == visited[dy][dx]) {
								origin = chessList.get(c);
								j--;
								break;
							}
						}
						visited[dy][dx] = 0;
						origin.put(chess.list);
						chessList.remove(chess);
						break;
					case 2: // blue
						chess.changeOrder();
						int changeOrder = chess.order;
						int blueX = chess.x + delta_x[changeOrder];
						int blueY = chess.y + delta_y[changeOrder];
						if(!(blueX < 0 || blueX >= N || blueY < 0 || blueY >= N)) {
							if(visited[blueY][blueX] == 0) {
								visited[blueY][blueX] = chess.num;
								visited[chess.y][chess.x] = 0;
								chess.x = blueX;
								chess.y = blueY;
							}
							else {
								for(int c=0;c<chessList.size();c++) {
									if(chessList.get(c).num == visited[blueY][blueX]) {
										origin = chessList.get(c);
										j--;
										break;
									}
								}
								visited[chess.y][chess.x] = 0;
								origin.put(chess.list);
								chessList.remove(chess);
							}
						}
						break;
					}
				}
			}
		}
		System.out.println(-1);
	}
	
	static class Chess {
		int x;
		int y;
		int num;
		int order; // left, right, up, down
		List<Integer> list = new ArrayList<>();
		
		public Chess() {}
		public Chess(int x, int y, int num, int order) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.order = order;
			this.list.add(num);
		}
		public void put(List<Integer> list) {
			for(int num : list) {
				this.list.add(num);
			}
		}
		public void reverse() {
			Collections.reverse(this.list);
		}
		public void changeOrder() {
			if((this.order&1) == 1) {
				this.order -= 1;
			}
			else {
				this.order += 1;
			}
		}
	}
}
