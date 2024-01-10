package backjoon;

import java.io.*;
import java.util.*;

public class BJ_2003 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n=0;n<N;n++){
            numbers[n] = Integer.parseInt(st.nextToken());
        }
        int start=0, end=0, sum=numbers[end];
        int count = 0;
        while(start < N){
            if(sum < M){
                end++;
                if(end >= N) break;
                sum += numbers[end];
            }
            else if(sum == M){
                count++;
                sum -= numbers[start];
                start++;
            }
            else{
                sum -= numbers[start];
                start++;
            }
        }
        System.out.println(count);
    }
}
