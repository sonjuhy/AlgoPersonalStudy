package backjoon.silver;

import java.io.*;
import java.util.*;

public class BJ_10773 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for(int k=0;k<K;k++){
            int n = Integer.parseInt(br.readLine());
            if(n == 0){
                stack.pop();
            }
            else{
                stack.add(n);
            }
        }
        int sum = 0;
        for(int s : stack){
            sum += s;
        }
        System.out.println(sum);
    }
}
