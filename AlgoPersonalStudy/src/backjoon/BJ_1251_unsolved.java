package backjoon;

import java.io.*;

public class BJ_1251_unsolved {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        char[] wordChar = word.toCharArray();
        int len = wordChar.length;
        int minLen = Integer.MAX_VALUE, point = 0;
        for(int i=0;i<len-2;i++){
            int wordInt = wordChar[i] - '0';
            if(wordInt < minLen){
                minLen = wordInt;
                point = i;
            }
        }
        int secondMinLen = Integer.MAX_VALUE, secondPoint = 0;
        for(int i=point+1;i<len-1;i++){
            int wordInt = wordChar[i] - '0';
            if(wordInt < secondMinLen){
                secondMinLen = wordInt;
                secondPoint = i;
            }
        }

        char[] first, second, thrid;
        first = word.substring(0, point+1).toCharArray();
        second = word.substring(point+1, secondPoint+1).toCharArray();
        thrid = word.substring(secondPoint+1).toCharArray();

        StringBuilder sb = new StringBuilder();
        for(int i=first.length-1;i>=0;i--){
            sb.append(first[i]);
        }
        for(int i=second.length-1;i>=0;i--){
            sb.append(second[i]);
        }
        for(int i=thrid.length-1;i>=0;i--){
            sb.append(thrid[i]);
        }
        System.out.println(sb.toString());
    }
}
