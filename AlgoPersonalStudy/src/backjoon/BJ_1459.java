package backjoon;

import java.io.*;
import java.util.*;

public class BJ_1459 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long X = Long.parseLong(st.nextToken());
		long Y = Long.parseLong(st.nextToken());
		long W = Long.parseLong(st.nextToken());
		long S = Long.parseLong(st.nextToken());
		
		long answer = 0;
		if(2*W > S) {
			long diff = Math.abs(X-Y);
			long tmp = diff*W + Math.min(X, Y) * S;
			if(diff % 2 == 0) {
				long side = Math.min(X, Y) * S + diff * S;
				answer = Math.min(tmp, side);
			}
			else {
				if(diff > 1) {
					long side = Math.min(X, Y) * S + W + (diff-1) * S;
					answer = Math.min(tmp, side);
				}
				else answer = tmp;
			}
		}
		else {
			answer = (X+Y) * W;
		}
		System.out.println(answer);
	}

}
