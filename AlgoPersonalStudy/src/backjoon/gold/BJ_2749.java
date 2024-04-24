package backjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2749 { // not solved alone
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int divNum = 1000000;

        int p = divNum / 10 * 15;
        int[] fibo = new int[p];
        
        for(int i=2;i<p;i++){
            fibo[i] = fibo[(i-1)] + fibo[(i-2)];
            fibo[i] %= divNum;
        }
        System.out.println(fibo[(p-1)]);
    }
}
