package backjoon;

import java.io.*;
import java.util.*;

public class BJ_21608 {

	static int[][] map;
	static int row = 3, col = 3;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[101][101];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=3;i++) {
			st = new StringTokenizer(br.readLine());
			map[i-1][0] = 3;
			map[0][i-1] = 3;
			for(int j=1;j<=3;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int count=0;count<100;count++) {
			
			if(map[r][c] == k) {
				System.out.println(count);
				return;
			}
			if(row >= col) {
				int topRow = row;
				for(int n=1;n<=row;n++) {
					ListCount[] tmp = new ListCount[101];
					int tmpMax = -1;
					for(int i=1;i<=map[n][0];i++) {
						tmpMax = Math.max(tmpMax, map[n][i]);
						if(tmp[map[n][i]] == null) {
							tmp[map[n][i]] = new ListCount(map[n][i], 1);
						}
						else {
							tmp[map[n][i]].count += 1;
						}
						
					}
					Arrays.sort(tmp);
					int place = 1;
					for(ListCount list : tmp) {
						map[n][count] = list.num;
						place++;
						map[n][count] = list.count;
						place++;
					}
//					for(int m=tmpMax;m>0;m--) {
//						if(tmp[m].count == 0) continue;
//						map[n][place] = m;
//						place++;
//						map[n][place] = tmp[m];
//						place++;
//					}
					map[n][0] = place-1;
					topRow = Math.max(place - 1, topRow);
				}
				row = Math.max(row, topRow);
			}
			else {
				int topCol = col;
				for(int n=1;n<=col;n++) {
					int[] tmp = new int[101];
					int tmpMax = -1;
					for(int i=1;i<=map[0][n];i++) {
						tmpMax = Math.max(tmpMax, map[i][n]);
						tmp[map[i][n]]++;
					}
					int place = 1;
					for(int m=tmpMax;m>0;m--) {
						if(tmp[m] == 0) continue;
						map[place][n] = m;
						place++;
						map[place][n] = tmp[m];
						place++;
					}
					map[0][n] = place-1;
					topCol = Math.max(place - 1, topCol);
				}
				col = Math.max(col, topCol);
			}
			print();
		}
		System.out.println(-1);
	}
	static class ListCount implements Comparable<ListCount>{
		int num;
		int count;
		
		public ListCount() {}
		public ListCount(int num, int count) {
			this.num = num;
			this.count = count;
		}
		@Override
		public int compareTo(ListCount o) {
			// TODO Auto-generated method stub
			if(o.count > this.count) {
				return 0;
			}
			else if(o.count == this.count){
				if(o.num > this.num) {
					return 0;
				}
				else {
					return 1;
				}
			}
			else {
				return 1;
			}
		}
	}
	static void print() {
		for(int i=1;i<=col;i++) {
			for(int j=1;j<=row;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
