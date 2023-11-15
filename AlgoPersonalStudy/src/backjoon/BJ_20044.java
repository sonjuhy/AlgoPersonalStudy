package backjoon;

import java.io.*;
import java.util.*;

public class BJ_20044 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N*2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0;n<2*N;n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int max = Integer.MAX_VALUE;
        for(int n=0;n<N;n++){
            max = Math.min(max, (arr[n] + arr[2*N-n-1]));
        }
        System.out.println(max);
    }
}
