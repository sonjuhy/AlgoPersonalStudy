package backjoon;

import java.io.*;
import java.util.*;

public class BJ_1927 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int n=0;n<N;n++) {
			int i = Integer.parseInt(br.readLine());
			if(i == 0) {
				if(queue.size() == 0) {
					sb.append(0+"\n");
				}
				else {
					sb.append(queue.poll()+"\n");
				}
			}
			else {
				queue.add(i);
			}
		}
		System.out.println(sb.toString());
	}

}
