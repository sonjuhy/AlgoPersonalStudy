package backjoon.silver;

import java.io.*;
import java.util.*;

public class BJ_1260 {
	static boolean[][] map;
	static StringBuilder staticSb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		HashSet<Integer> dfsSet = new HashSet<>();
		HashSet<Integer> bfsSet = new HashSet<>();
		
		map = new boolean[N+1][N+1];
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = true;
			map[b][a] = true;
			dfsSet.add(a);
			dfsSet.add(b);
			bfsSet.add(a);
			bfsSet.add(b);
		}
		if(dfsSet.contains(V)) {
			DFS(dfsSet, V, 0);
			System.out.println(staticSb.toString());
			BFS(bfsSet, V, N);
		}
		else{
			System.out.println(V);
			System.out.println(V);
		}
	}
	static void DFS(HashSet<Integer> hashSet, int v, int dep) {
		if(!hashSet.isEmpty()){
			staticSb.append(v).append(" ");
			hashSet.remove(v);
			List<Integer> tmpSetList = new ArrayList<>(hashSet);
			for(int num : tmpSetList){
				if(hashSet.contains(num)){
					if(map[v][num]) {
						DFS(hashSet, num, dep + 1);
					}
				}
			}
		}
	}
	static void BFS(HashSet<Integer> hashSet, int v, int n) {
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			for(int q=0;q<queueSize;q++) {
				int num = queue.poll();
				if(!hashSet.contains(num)) continue;
				hashSet.remove(num);
				sb.append(num).append(" ");
				for(int des : new ArrayList<>(hashSet)){
					if(map[num][des]){
						queue.add(des);
					}
				}
			}
		}
		System.out.println(sb.toString());
	}
}
