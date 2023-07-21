package backjoon;

import java.io.*;
import java.util.*;

public class BJ_15989 {
	static int answer = 0;
	static HashMap<String, Boolean> hash = new HashMap<>();
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<T;t++) {
			int num = Integer.parseInt(br.readLine());
			calc(num,0,0,0);
			sb.append(answer+"\n");
			answer = 0;
			hash.clear();
		}
		System.out.println(sb.toString());
	}
	public static void calc(int num, int three, int two, int one) {
		if(num == 0) {
			String key = three + "," + two + "," + one;
			if(!hash.containsKey(key)) {
				hash.put(key, true);
				answer++;
			}
			return;
		}
		if(num >=3) calc(num-3, three+1, two, one);
		if(num >=2) calc(num-2, three, two+1, one);
		if(num >=1) calc(num-1, three, two, one+1);
	}
}
