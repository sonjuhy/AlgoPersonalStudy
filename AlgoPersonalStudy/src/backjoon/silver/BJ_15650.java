package backjoon.silver;

import java.io.*;
import java.util.*;

public class BJ_15650 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        boolean[] visited = new boolean[N];

        for(int n=0;n<N;n++) arr[n] = n+1;
        backTracking(arr, visited, 0, M);
    }
    static void backTracking(int[] arr, boolean[] visited, int start, int dep){
        if(dep == 0){
            for(int i=0;i<arr.length;i++){
                if(visited[i]) System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=start;i<arr.length;i++) {
            visited[i] = true;
            backTracking(arr, visited, i + 1, dep - 1);
            visited[i] = false;
        }
    }
}
