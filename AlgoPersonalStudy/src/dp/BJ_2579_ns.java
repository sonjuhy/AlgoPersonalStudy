package dp;

import java.io.*;

public class BJ_2579_ns {
	static int[] arr;
	static int answer = 0;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for(int n=0;n<N;n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}
		calc(0,0,0);
		System.out.println(answer);
	}
	/*
	 * 1. 1칸 혹은 2칸 갈 수 있다.
	 * 2. 단 세번째는 패스다.
	 * 3. 마지막은 밟아야한다.
	 * */
	static void calc(int num, int count, int deps) {
		if(deps >= arr.length) {
			if(deps == arr.length) answer = Math.max(answer, num);
			return;
		}
		int tmpCount = count + 1;
		
		if(tmpCount > 2) {
			calc(num, 0, deps+1);
		}
		else {
			calc(num+arr[deps+1], count+1, deps+1);
			calc(num+arr[deps+2], count+1, deps+2);
		}
	}
}
