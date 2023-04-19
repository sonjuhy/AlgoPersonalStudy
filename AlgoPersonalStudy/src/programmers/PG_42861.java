package programmers;

import java.util.*;

public class PG_42861 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=4;
		int[][] costs = new int[][] {{0,1,1},{0,2,2},{1,2,1},{1,3,5},{2,3,8}};
		//[[0, 1, 1], [0, 2, 2], [1, 2, 1], [1, 3, 5], [2, 3, 8]]
//		int[][] costs = new int[][] {{0, 1, 5}, {0, 3, 2}, {0, 4, 3}, {1, 4, 1}, {3, 4, 10}, {1, 2, 2}, {2, 5, 3}, {4, 5, 4}};
		int result = solution(n, costs);
		System.out.println(result);
	}
	public static int solution(int n, int[][] costs) {
		int answer = 0;
        List<int[]> list = new ArrayList<>();
        for(int[] cost : costs){
            list.add(cost);
        }
        Collections.sort(list, (a,b) -> a[2] - b[2]);
        
        int[] connections = new int[n];
        
        int count = 0, place = 0;
        while(count < n-1){
            int start = list.get(place)[0];
            int end = list.get(place)[1];
            int cost = list.get(place)[2];
            place++;
            if(connections[start] != connections[end]) {
            	count++;
                int max = Math.max(connections[start], connections[end]);
                int min = Math.min(connections[start], connections[end]);
                if(min == 0) {
                	connections[start] = max;
                	connections[end] = max;
                }
                else for(int i=0;i<connections.length;i++) if(connections[i] == min) connections[i] = max;
                answer += cost;
            }
            else if(connections[start] == connections[end] && connections[start] == 0){
            	count++;
                connections[start] = count;
                connections[end] = count;
                answer += cost;
            }
           
        }
        return answer;
	}
}
