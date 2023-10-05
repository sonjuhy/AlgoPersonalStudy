package dp;

import java.io.*;

public class BJ_9095_self {
	static int answer = 0;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			calc(N);
			System.out.println(answer);
			answer = 0;
		}
	}
	static void calc(int num) {
		if(num == 0) {
			answer++;
			return;
		}
		if(num >= 3) {
			calc(num-3);
		}
		if(num >= 2) {
			calc(num-2);
		}
		if(num >= 1) {
			calc(num-1);
		}
	}
}
