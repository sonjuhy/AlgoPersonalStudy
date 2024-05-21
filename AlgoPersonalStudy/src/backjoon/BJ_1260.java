package backjoon;

import java.io.*;
import java.util.*;

public class BJ_1260 {
	static boolean[][] map;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, Integer> hash = new HashMap<>();
		
		map = new boolean[N+1][N+1];
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = true;
			map[b][a] = true;
			hash.put(a, b);
			hash.put(b, a);
		}
		int count = hash.size();
		DFS(V,N, count);
		BFS(V,N);
	}
	static void DFS(int v, int n, int count) {
		StringBuilder sb = new StringBuilder();
		boolean[] visited = new boolean[n+1];
		int visitedCount = 1, point = v;
		
		sb.append(point).append(" ");
		while(visitedCount < count) {
			for(int i=1;i<=n;i++) {
				if(visited[i]) continue;
				if(map[point][i]) {
					visited[point] = true;
					point = i;
					visitedCount++;
					sb.append(point).append(" ");
					break;
				}
			}
		}
		System.out.println(sb.toString());
	}
	static void BFS(int v, int n) {
		StringBuilder sb = new StringBuilder();
		
		boolean[] visited = new boolean[n+1];
		visited[v] = true;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			for(int q=0;q<queueSize;q++) {
				int num = queue.poll();
				sb.append(num).append(" ");
				for(int i=1;i<=n;i++) {
					if(visited[i]) continue;
					if(map[num][i]) {
						visited[i] = true;
						queue.add(i);
					}
				}
			}
		}
		System.out.println(sb.toString());
	}
}
