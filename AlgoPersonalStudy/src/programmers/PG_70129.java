package programmers;

import java.util.*;
import java.io.*;

public class PG_70129 {
    public static void main(String[] args) {
        String str = "1111111";
        int[] answer = solution(str);
        System.out.println(answer[0]+", "+answer[1]);
    }

    public static int[] solution(String s){
        int[] answer;
        int count=0, zeroCount=0;
        String tmpStr = s;
        while(true){
            count++;
            char[] tmpChar = tmpStr.toCharArray();
            int tmpLen = 0;
            for(char c : tmpChar){
                if(c=='0') zeroCount++;
                else tmpLen++;
            }
            tmpStr = Integer.toBinaryString(tmpLen);
            if(tmpStr.equals("1")) break;
        }
        answer = new int[]{count, zeroCount};
        return answer;
    }
}
