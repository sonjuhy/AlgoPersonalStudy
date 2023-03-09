package backjoon;

import java.io.*;
import java.util.*;

public class BJ_14501 {
	static int answer = 0, N = 0;
	static int[] T,P;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		T = new int[N];
		P = new int[N];
		StringTokenizer st;
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			T[n] = Integer.parseInt(st.nextToken());
			P[n] = Integer.parseInt(st.nextToken());
		}
		for(int n=0;n<N;n++) {
			calc(n,0);
		}
		System.out.println(answer);
	}

	static void calc(int day, int price) {
		if(day >= N) {
			answer = Math.max(answer, price);
			return;
		}
		
		int next = day + T[day];
		if(next > N) next = N;
		else {
			price += P[day];
		}
		for(int n=next;n<=N;n++) {
			calc(n, price);
		}
	}
}
