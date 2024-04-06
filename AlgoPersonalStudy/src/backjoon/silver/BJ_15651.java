package backjoon.silver;

import java.io.*;
import java.util.*;

public class BJ_15651 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] intArr = new int[M];
        int[] arr = new int[N];

        for(int n=0;n<N;n++) arr[n] = n+1;
        for(int n=0;n<N;n++) {
            intArr[M-1] = n+1;
            backTracking(arr,  intArr, M-1);
        }
        System.out.println(sb.toString());
    }
    static void backTracking(int[] arr, int[] answer, int dep){
        if(dep == 0){
            for(int i=answer.length-1;i>=0;i--) sb.append(answer[i]).append(" ");
            sb.append("\n");
            return;
        }
        for(int i=0;i<arr.length;i++) {
            answer[dep-1] = i+1;
            backTracking(arr,  answer, dep - 1);
        }
    }
}
