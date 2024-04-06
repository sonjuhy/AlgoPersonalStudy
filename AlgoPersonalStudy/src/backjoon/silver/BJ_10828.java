package backjoon.silver;

import java.io.*;
import java.util.*;

public class BJ_10828 {
    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for(int n=0;n<N;n++){
            String[] strArr = br.readLine().split(" ");
            if("push".equals(strArr[0])){
                stack.push(Integer.parseInt(strArr[1]));
            }
            else if("pop".equals(strArr[0])){
                if(stack.isEmpty()) sb.append(-1).append("\n");
                else{
                    sb.append(stack.pop()).append("\n");
                }
            }
            else if("size".equals(strArr[0])){
                sb.append(stack.size()).append("\n");
            }
            else if("empty".equals(strArr[0])){
                if(stack.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            else if("top".equals(strArr[0])){
                if(stack.isEmpty()) sb.append(-1).append("\n");
                else{
                    sb.append(stack.peek()).append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
