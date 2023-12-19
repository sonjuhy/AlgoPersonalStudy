package programmers;

import java.util.Arrays;

public class PG_12948 {
    public static void main(String[] args) {
        String phone_number = "01033334444";
        String result = solution(phone_number);
        System.out.println(result);
    }
    public static String solution(String phone_number){
        StringBuilder answer = new StringBuilder();
        int len = phone_number.length();
        char[] charArr = phone_number.toCharArray();
        for(int i=0;i<len-4;i++){
            charArr[i] = '*';
        }
        for(char c : charArr){
            answer.append(c);
        }
        return answer.toString();
    }
}
