package programmers;

import java.util.*;

public class PG_49189 {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6},{4, 3},{3, 2},{1, 3},{1, 2},{2, 4},{5, 2}};
        int result = solution(n, edge);
        System.out.println(result);
    }
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];

        visited[1] = true;
        distance[1] = -1;

        HashMap<Integer, List<Integer>> nodeMap = new HashMap<>();
        for(int[] node : edge){
            if(nodeMap.containsKey(node[0])){
                if(!nodeMap.get(node[0]).contains(node[1])) nodeMap.get(node[0]).add(node[1]);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(node[1]);
                nodeMap.put(node[0], list);
            }
            if(nodeMap.containsKey(node[1])){
                if(!nodeMap.get(node[1]).contains(node[0])) nodeMap.get(node[1]).add(node[0]);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(node[0]);
                nodeMap.put(node[1], list);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        int disCount = 0;
        while(!queue.isEmpty()){
            disCount++;
            int qSize = queue.size();
            for(int q=0;q<qSize;q++){
                List<Integer> list = nodeMap.get(queue.poll());
                if(list == null) continue;
                for(int node : list){
                    if(visited[node]) continue;
                    visited[node] = true;
                    distance[node] = disCount;
                    queue.add(node);
                }
            }
        }
        Arrays.sort(distance);
        disCount = distance[n];
        for(int d=n;d>0;d--){
            if(distance[d] == disCount) answer++;
            else break;
        }
        return answer;
    }
}
