package backjoon;

import java.io.*;
import java.util.*;

public class BJ_22233 {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Boolean> map = new HashMap<>();
		for(int n=0;n<N;n++) {
			map.put(br.readLine(), true);
		}
		StringBuilder sb = new StringBuilder();
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine(), ",");
			while(st.hasMoreTokens()) {
				String str = st.nextToken();
				if(map.containsKey(str)) {
					map.remove(str);
				}
			}
			sb.append(map.size()+"\n");
		}
		System.out.println(sb.toString());
	}
}
