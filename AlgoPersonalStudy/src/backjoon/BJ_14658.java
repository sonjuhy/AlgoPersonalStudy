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
		
		int xMax = 0, xMin = 500000, yMax = 0, yMin = 500000;
		Point[] points = new Point[K];
		
		for(int k=0;k<K;k++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points[k] = new Point(x,y);
			if(xMax < x) {
				xMax = x;
			}
			if(xMin > x) {
				xMin = x;
			}
			if(yMax < y) {
				yMax = y;
			}
			if(yMin > y) {
				yMin = y;
			}
		}
		int min = K;
		if(xMax - xMin > L || yMax - yMin > L) {
			for(int i=xMin;i<=xMax;i++) {
				for(int j=yMin;j<=yMax;j++) {
					int tmp = 0;
					for(int k=0;k<K;k++) {
						if(points[k].x >= i && points[k].x <= i+L && points[k].y >= j && points[k].y <= j+L) tmp++;
					}
					min = Math.min(min, K-tmp);
				}
			}
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