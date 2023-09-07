package backjoon;

import java.io.*;
import java.util.*;

public class BJ_1655 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> minQueue = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> maxQueue = new PriorityQueue<>();
		
		
		for(int n=0;n<N;n++) {
			int num = Integer.parseInt(br.readLine());
			
			if(minQueue.size() == maxQueue.size()) minQueue.add(num);
			else maxQueue.add(num);
			
			if(!minQueue.isEmpty() && !maxQueue.isEmpty()) {
				if(maxQueue.peek() < minQueue.peek()) {
					int tmp = maxQueue.poll();
					maxQueue.add(minQueue.poll());
					minQueue.add(tmp);
				}
			}
			
			sb.append(minQueue.peek()+"\n");
		}
		System.out.println(sb.toString());
	}
}
