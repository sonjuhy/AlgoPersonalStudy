package backjoon;

import java.io.*;
import java.util.*;

public class BJ_1019 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		long[] answer = new long[10];
		for(int n=0;n<=N;n++) {
			int tmp = n;
			while(tmp != 0) {
				int other = tmp % 10;
				answer[other]++;
				tmp = tmp/10;
			}
			
//			if(n % 10 == 0 && n > 0) {
//				StringBuilder sb = new StringBuilder();
//				for(int i=0;i<10;i++) {
//					sb.append(answer[i]+" ");
//				}
//				System.out.println(sb);
//			}
			
		}
		System.out.println("result");
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<10;i++) {
			sb.append(answer[i]+" ");
		}
		System.out.println(sb);
	}

}
