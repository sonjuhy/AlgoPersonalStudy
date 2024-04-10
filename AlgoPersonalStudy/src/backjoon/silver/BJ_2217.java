package backjoon.silver;

import java.io.*;
import java.util.Arrays;

public class BJ_2217 {
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int n=0;n<N;n++){
            arr[n] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int maxWeight = 0;
        for(int n=0;n<N;n++){
            maxWeight = Math.max(maxWeight, arr[n]*(N-n));
        }
        System.out.println(maxWeight);
    }
}
