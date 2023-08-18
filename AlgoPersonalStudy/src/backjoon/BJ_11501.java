package backjoon;

import java.io.*;
import java.util.*;

public class BJ_11501 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
			int point = -1, tmpPoint = 0, sum = 0;
			int max = 0;
			while(point < N-1) {
				point++;
				boolean same = true;
				for(int n=point;n<N;n++) {
					if(max < arr[n]) {
						max = arr[n];
						point = n;
					}
					else if(max > arr[n]) {
						same = false;
					}
				}
				if(point == tmpPoint) {
					if(same) break;
					else {
						tmpPoint = point + 1;
						max = 0;
						continue;
					}
				}
				for(int n=tmpPoint;n<point;n++) {
					sum += max - arr[n];
				}
				max = 0;
				tmpPoint = point+1;
			}
			sb.append(sum+"\n");
		}
		System.out.println(sb.toString());
	}

}
