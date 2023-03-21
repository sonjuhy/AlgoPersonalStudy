package backjoon;

import java.util.*;
import java.io.*;

public class BJ_14888 {
	
	static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int N;
	static int[] expresstion, symbol, A;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = new int[N];
		expresstion = new int[N-1];
		visited = new boolean[N-1];
		
		for(int a=0;a<N;a++) {
			A[a] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		symbol = new int[4]; // +, -, *, /
		for(int s=0;s<4;s++) {
			symbol[s] = Integer.parseInt(st.nextToken());
		}
		subset(0);
		System.out.println(max);
		System.out.println(min);
	}
	static void subset(int deps) {
		if(deps >= N-1) {
			int tmp = A[0];
			for(int n=0;n<N-1;n++) {
				if(expresstion[n] < symbol[0]) { // plus symbol
					tmp += A[n+1];
				}
				else if(expresstion[n] < symbol[1]+symbol[0]) { // minus symbol
					tmp -= A[n+1];
				}
				else if(expresstion[n] < symbol[2]+symbol[1]+symbol[0]) { // multi symbol
					tmp *= A[n+1];
				}
				else {
					tmp /= A[n+1];
				}
			}
			max = Math.max(tmp, max);
			min = Math.min(tmp, min);
			return;
		}
		for(int n=0;n<N-1;n++) {
			if(visited[n]) continue;
			visited[n] = true;
			expresstion[deps] = n;
			subset(deps+1);
			visited[n] = false;
		}
	}
}
