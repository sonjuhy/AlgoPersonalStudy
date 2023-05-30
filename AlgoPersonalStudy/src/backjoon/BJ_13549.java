package backjoon;

import java.io.*;
import java.util.*;

public class BJ_13549 {

	static int N,K;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] visited = new int[100001];
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {N,1});
		visited[N] = 1;
		while(!queue.isEmpty()) {
			int[] load = queue.poll();
			int x = load[0];
			if(x * 2 <= 100000 && (visited[x*2] == 0 || visited[x*2] > load[1])) {
				visited[x*2] = load[1];
				queue.add(new int[] {x * 2, load[1]});
			}
			if(x - 1 >= 0 && (visited[x-1] == 0 || visited[x-1] > load[1]+1)) {
				visited[x-1] = load[1] + 1;
				queue.add(new int[] {x - 1, load[1] + 1});
			}
			if(x + 1 <= 100000 && (visited[x+1] == 0 || visited[x+1] > load[1]+1)) {
				visited[x+1] = load[1] + 1;
				queue.add(new int[] {x + 1, load[1] + 1});
			}
		}
		System.out.println(visited[K] - 1);
	}
}

