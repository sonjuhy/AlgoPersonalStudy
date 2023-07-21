package backjoon;

import java.io.*;
import java.util.*;

public class BJ_11723 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] set = new boolean[21];
		StringBuilder sb = new StringBuilder();
		for(int n=0;n<N;n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			int num = -1;
			switch(order) {
			case "add":
				num = Integer.parseInt(st.nextToken());
				set[num] = true;
				break;
			case "remove":
				num = Integer.parseInt(st.nextToken());
				set[num] = false;
				break;
			case "check":
				num = Integer.parseInt(st.nextToken());
				if(set[num]) sb.append(1+"\n");
				else sb.append(0+"\n");
				break;
			case "toggle":
				num = Integer.parseInt(st.nextToken());
				set[num] = !set[num];
				break;
			case "all":
				Arrays.fill(set, true);
				break;
			case "empty":
				Arrays.fill(set, false);
				break;
			}
		}
		System.out.println(sb.toString());
	}

}
