package programmers;

import java.util.*;

public class PG_12939 {
    public static void main(String[] args) {
        String s = "1 2 3 4";
        String result = solution(s);
        System.out.println(result);
    }
    public static String solution(String s){
        String answer = "";

        String[] arrString = s.split(" ");
        int len = arrString.length;
        int[] arr = new int[len];
        for(int i=0;i<len;i++){
            arr[i] = Integer.parseInt(arrString[i]);
        }
        Arrays.sort(arr);
        answer = arr[0]+" "+arr[len-1];
        return answer;
    }
}
