package programmers;

import java.util.*;
import java.io.*;
public class PG_12933 {
    public static void main(String[] args) {
        long n = 0;
        long result = solution(n);
        System.out.println(result);
    }
    public static long solution(long n){
        long answer = 0;
        String nStr = String.valueOf(n);
        char[] nCharArr = nStr.toCharArray();
        Arrays.sort(nCharArr);
        StringBuilder sb = new StringBuilder();
        for(int i=nCharArr.length-1;i>=0;i--){
            sb.append(nCharArr[i]);
        }
        answer = Long.parseLong(sb.toString());
        return answer;
    }
}
