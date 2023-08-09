package backjoon;

import java.io.*;
import java.util.*;

public class BJ_14658 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int xMax = L, xMin = 1, yMax = L, yMin = 1;
		Point[] points = new Point[K];
		
		for(int k=0;k<K;k++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points[k] = new Point(x,y);
		}
		int min = K;
		for(int i=0;i<=N-L;i++) {
			for(int j=0;j<=M-L;j++) {
				int tmp = 0;
				for(int k=0;k<K;k++) {
					if(points[k].x >= xMin && points[k].x <= xMax && points[k].y >= yMin && points[k].y <= yMax) tmp++;
				}
				System.out.println(tmp);
				min = Math.min(min, K-tmp);
				yMax++;
				yMin++;
			}
			xMax++;
			xMin++;
			yMax = L;
			yMin = 1;
		}
		System.out.println(min);
	}
	static class Point{
		int x;
		int y;
		public Point() {}
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}