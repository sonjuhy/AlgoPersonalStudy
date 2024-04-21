package backjoon.silver;

import java.io.*;
import java.util.*;

public class BJ_11399 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0;n<N;n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int answer = 0;

        for(int n=0;n<N;n++){
            answer += arr[N-n-1]*(n+1);
        }
        System.out.println(answer);
    }
}
