package programmers;

import java.io.*;
import java.util.*;

public class PG_12909 {
    public static void main(String[] args) {
        String s = "(()(";
        System.out.println(solution(s));
    }
    public static boolean solution(String s){
        boolean answer = true;
        char[] charArr = s.toCharArray();
        if(charArr.length % 2 == 1) return false;

        Stack<Character> stack = new Stack<>();
        for(char c : charArr){
            if(c == '('){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    answer = false;
                    break;
                }
                stack.pop();
            }
        }
        if(!stack.isEmpty()) answer = false;
        return answer;
    }
}
