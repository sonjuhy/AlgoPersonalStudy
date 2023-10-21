package dp;

import java.io.*;

public class BJ_24416 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int dp = N-2;
		int self = fibo(N);
		System.out.println(self+" "+dp);
	}
	static int fibo(int n) {
		if(n == 1 || n == 2) return 1;
		else return (fibo(n-1)+fibo(n-2));
	}

}
