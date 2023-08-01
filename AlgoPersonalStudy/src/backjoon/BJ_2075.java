package backjoon;

import java.io.*;
import java.util.*;

public class BJ_2075 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int n=0;n<N;n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				pq.add(Integer.parseInt(st.nextToken()));
				if(pq.size() > N) pq.poll();
			}
		}
		System.out.println(pq.poll());
	}

}
