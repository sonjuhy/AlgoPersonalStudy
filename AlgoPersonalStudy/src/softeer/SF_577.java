package softeer;

import java.io.*;
import java.util.*;

public class SF_577 {
	
	static int[] delta_x = {0,1,0,-1};
	static int[] delta_y = {1,0,-1,0};

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		
		for(int n=0;n<N;n++) {
			map[n] = br.readLine().toCharArray();
		}
		
		int[] startPoint = getStartPoint(map, N,M);
		int[] endPoint = getEndPoint(map, N, M, startPoint);
		System.out.println((startPoint[0]+1)+" "+(startPoint[1] + 1));
		
		int[] nowPoint = startPoint.clone();
		int beforePoint = 100;
		
		int orderInt = getOrderInt(map, startPoint, beforePoint, N, M);
		char order = getOrder(orderInt);
		System.out.println(order);
		
		StringBuffer sb = new StringBuffer();
		
		
		boolean loop = true;
		int dy = 0, dx = 0;
		while(loop) {
			switch(orderInt) {
			case 0:
				dy = nowPoint[0] + 2;
				if(dy >= N || map[dy][nowPoint[1]] != '#' || map[dy-1][nowPoint[1]] != '#') {
					orderInt = getOrderInt(map, nowPoint, beforePoint, N, M);
					if(orderInt == 1) sb.append("L");
					else sb.append("R");
					order = getOrder(orderInt);
				}
				else {
					sb.append("A");
					nowPoint[0] += 2;
				}
				break;
			case 1:
				dx = nowPoint[1] + 2;
				if(dx >= M || map[nowPoint[0]][dx] != '#' || map[nowPoint[0]][dx-1] != '#') {
					orderInt = getOrderInt(map, nowPoint, beforePoint, N, M);
					if(orderInt == 2) sb.append("L");
					else sb.append("R");
					order = getOrder(orderInt);
				}
				else {
					sb.append("A");
					nowPoint[1] += 2;
				}
				break;
			case 2:
				dy = nowPoint[0] - 2;
				if(dy < 0 || map[dy][nowPoint[1]] != '#' || map[dy+1][nowPoint[1]] != '#') {
					orderInt = getOrderInt(map, nowPoint, beforePoint, N, M);
					if(orderInt == 3) sb.append("L");
					else sb.append("R");
					order = getOrder(orderInt);
				}
				else {
					sb.append("A");
					nowPoint[0] -= 2;
				}
				break;
			case 3:
				dx = nowPoint[1] - 2;
				if(dx < 0 || map[nowPoint[0]][dx] != '#' || map[nowPoint[0]][dx+1] != '#') {
					orderInt = getOrderInt(map, nowPoint, beforePoint, N, M);
					if(orderInt == 0) sb.append("L");
					else sb.append("R");
					order = getOrder(orderInt);
				}
				else {
					sb.append("A");
					nowPoint[1] -= 2;
				}
				break;
			}
			if(nowPoint[0] == endPoint[0] && nowPoint[1] == endPoint[1]) {
				break;
			}
			beforePoint = orderInt;
		}
		System.out.println(sb.toString());
	}
	static int getOrderInt(char[][] map,int[] startPoint, int beforeOrder, int N, int M) {
		int orderInt = -1;
		for(int d=0;d<4;d++) {
			int dx = startPoint[1] + delta_x[d];
			int dy = startPoint[0] + delta_y[d];
			if(dx < 0 || dx >= M || dy < 0 || dy >= N) continue;
			if(Math.abs(beforeOrder - d) == 2) continue;
			if(map[dy][dx] == '#') {
				orderInt = d;
				break;
			}
		}
		return orderInt;
	}
	static char getOrder(int orderInt) {
		char order = 0;
		switch(orderInt) {
		case 0:
			order = 'v';
			break;
		case 1:
			order = '>';
			break;
		case 2:
			order = '^';
			break;
		case 3:
			order = '<';
			break;
		}
		return order;
	}
	static int[] getStartPoint(char[][] map, int N, int M) {
		int[] startPoint = new int[2];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == '#') {
					boolean check = true;
					for(int d=0;d<3;d++) {
						int dx = j + delta_x[d];
						int dy = i + delta_y[d];
						if(dx < 0 || dx >= M || dy < 0 || dy >= N) continue;
						if(map[dy][dx] == '#') {
							check = false;
							break;
						}
					}
					
					if(check) {
						startPoint[0] = i;
						startPoint[1] = j;
						return startPoint;
					}
				}
			}
		}
		return startPoint;
	}
	static int[] getEndPoint(char[][] map, int N, int M, int[] startPoint) {
		int[] endPoint = new int[2];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == '#') {
					if(!(i == startPoint[0] && j == startPoint[1])) {
						boolean check = true;
						int count = 0;
						for(int d=0;d<4;d++) {
							int dx = j + delta_x[d];
							int dy = i + delta_y[d];
							if(dx < 0 || dx >= M || dy < 0 || dy >= N) continue;
							if(map[dy][dx] == '#') {
								count++;
							}
						}
						if(count > 1) check = false;
						if(check) {
							endPoint[0] = i;
							endPoint[1] = j;
							return endPoint;
						}
					}
				}
			}
		}
		return endPoint;
	}
}
