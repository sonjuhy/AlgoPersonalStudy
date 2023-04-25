package codesignal;

import java.io.*;
import java.util.*;

public class CS_question1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(solution(br.readLine()));

	}
	public static String solution(String s) {
	    String answer = null;
	    char[] ch = s.toCharArray();
//	    System.out.println(new String(Arrays.copyOfRange(ch, 0, 4)));
	    while(ch.length > 0){
	        int replace = 0;
	        for(int c=0;c<ch.length;c++){
	            char[] tmpChar = Arrays.copyOfRange(ch, 0, c+1);
	            
	            boolean check = false;
	            for(int tmpC=0;tmpC<c;tmpC++){
	                int reverse = c-tmpC;
	                if(tmpChar[tmpC] != tmpChar[reverse]) {
	                	check = true;
	                	break;
	                }
	            }
	            
	            if(check) continue;
	            else {
	                replace = Math.max(replace, c+1);
	                System.out.println("replace : " + replace);
	            }
	        }
	        if(replace <= 1) break;
	        ch = Arrays.copyOfRange(ch, replace, ch.length);
	        System.out.println(new String(ch));
	    }
	    
	    answer = new String(ch);
	    return answer;
	}

}
