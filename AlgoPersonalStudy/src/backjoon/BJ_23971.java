package backjoon;

import java.io.*;
import java.util.*;

public class BJ_23971 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = (int) (Math.round(H / (1.0+N)) * Math.round(W / (1.0+M)));
		System.out.println(answer);
	}

}
