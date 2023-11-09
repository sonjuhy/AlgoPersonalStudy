package backjoon;

import java.io.*;
import java.util.*;

public class BJ_2606 {
    static int answer = 0;
    static boolean[] visited;
    static HashMap<Integer, List<Integer>> hashMap;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        visited[1] = true;
        hashMap = new HashMap<>();

        for (int m = 0; m < M; m++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(hashMap.containsKey(start)){
                hashMap.get(start).add(end);
                if(hashMap.containsKey(end)){
                    if(!hashMap.get(end).contains(start)) hashMap.get(end).add(start);
                }
                else{
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    hashMap.put(end, list);
                }
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(end);
                hashMap.put(start, list);
                if(hashMap.containsKey(end)){
                    if(!hashMap.get(end).contains(start)) hashMap.get(end).add(start);
                }
                else{
                    List<Integer> endList = new ArrayList<>();
                    endList.add(start);
                    hashMap.put(end, endList);
                }
            }
        }
        dfs(1);
        System.out.println(answer);
    }
    static void dfs(int start){
        List<Integer> list = hashMap.get(start);
        if(list == null || list.size() == 0) return;
        for(int end : list){
            if(visited[end]) continue;
            visited[end] = true;
            answer++;
            dfs(end);
        }
    }
}