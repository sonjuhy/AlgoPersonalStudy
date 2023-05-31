package backjoon;

import java.io.*;
import java.util.*;

public class BJ_20922 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		
		int answer = 0, lastN = 0;
		
		for(int n=0;n<N;n++) {
			int a = Integer.parseInt(st.nextToken());
			if(hashMap.containsKey(a)) {
				int overlap = hashMap.get(a);
				if(overlap + 1 > K || n == N-1) {
					int tmp = n - lastN;
					lastN = n-1;
					answer = Math.max(answer, tmp);
				}
				else {
					hashMap.put(a, overlap+1);
				}
			}
			else {
				hashMap.put(a, 1);
			}
			if(n == N-1) {
				int tmp = n - lastN;
				answer = Math.max(answer, tmp);
			}
		}
		
		System.out.println(answer);
	}

}
