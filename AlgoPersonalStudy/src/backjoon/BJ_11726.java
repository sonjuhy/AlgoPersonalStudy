package backjoon;

import java.util.*;
import java.io.*;

public class BJ_11726 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;

		int sum = N, first = 1, second = 2;
		for(int n=3;n<=N;n++) {
			sum = (first + second) % 10007;
			first = second;
			second = sum;
		}
		answer = sum;
		
		
		System.out.println(answer);
	}

}
