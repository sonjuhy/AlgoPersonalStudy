package backjoon;

import java.io.*;
import java.util.PriorityQueue;

public class BJ_2668 {
	static int N = 0, tmpCount = 0;
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		
		for(int n=0;n<N;n++) {
			arr[n] = Integer.parseInt(br.readLine()) - 1;
		}
		int count = 0;
		for(int n=0;n<N;n++) {
			boolean result = dfs(n, arr[n]);
			if(result) {
				count += tmpCount;
				tmpCount = 0;
			}
			else {
				tmpCount = 0;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(count+"\n");
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int n=0;n<N;n++) {
			if(visited[n]) {
				pq.add(n);
			}
		}
		while(!pq.isEmpty()) {
			sb.append((pq.poll()+1)+"\n");
		}
		System.out.println(sb.toString());
	}
	static boolean dfs(int frist, int point) {
		if(visited[point]) {
			if(visited[frist]) return true;
			else return false;
		}
		visited[point] = true;
		
		int nextPoint = arr[point];
		tmpCount++;
		visited[point] = dfs(frist, nextPoint);
		return visited[point];
	}
}
