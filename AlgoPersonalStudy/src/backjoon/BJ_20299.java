package backjoon;

import java.io.*;
import java.util.*;

public class BJ_20299 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int count = 0;
		StringBuilder sb = new StringBuilder();
		
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			boolean result = true;
			String tmp = "";
			int total = 0;
			for(int i=0;i<3;i++) {
				int a = Integer.parseInt(st.nextToken());
				if(a < L) {
					result = false;
					break;
				}
				total += a;
				tmp += a+" ";
			}
			if(result && total >= K) {
				count++;
				sb.append(tmp);
			}
		}
		System.out.println(count);
		System.out.println(sb.toString());
	}

}
