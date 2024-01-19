package dp;

import java.io.*;
import java.util.*;

public class BJ_1912 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = example(N, arr);
        System.out.println(answer);
    }
    public static int example(int N, int[] arr){
        int answer = 0;
        int[] dp = new int[10000];
        for(int i=1;i<N;i++){
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            answer = Math.max(dp[i], answer);
        }
        return answer;
    }
}
