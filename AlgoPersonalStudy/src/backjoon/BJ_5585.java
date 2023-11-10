package backjoon;

import java.io.*;
import java.util.*;

public class BJ_5585 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int money = 1000 - N;
        int answer;
        answer = money / 500 + (money % 500) / 100 + (money % 100) / 50 + (money % 50) / 10 + (money % 10) / 5 + (money % 5);
        System.out.println(answer);
    }
}
