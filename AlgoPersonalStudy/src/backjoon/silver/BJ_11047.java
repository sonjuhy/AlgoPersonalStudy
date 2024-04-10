package backjoon.silver;

import java.io.*;
import java.util.*;

public class BJ_11047 {
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int answer = 0;
        int leftCoin = K;
        int[] coins = new int[N];
        for(int i=0;i<N;i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
        if(K == coins[N-1]){
            answer = 1;
        }
        else{
            for(int i=N-1;i>=0;i--){
                int div = leftCoin / coins[i];
                if(div > 0){
                    answer += div;
                    leftCoin %= coins[i];
                }
            }
        }
        System.out.println(answer);
    }
}
