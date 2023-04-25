package codesignal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.*;
import java.util.*;

public class CS_question2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = {1,2};
		System.out.println(solution(a));
	}
	static long solution(int[] a) {
	    long answer = 0;
	    
	    Arrays.sort(a);
	    int[] b = Arrays.stream(a).distinct().toArray();
	    int[] c = new int[b.length];
	    int len = b.length;
	    int before = a[0], place = 0, count = 0;
	    for(int i : a){
	        if(before != i) {
	            c[place] = count;
	            place++;
	            count = 0;
	        }
	        before = i;
	        count++;
	    }
	    c[c.length-1] = count;
	    // for(int i : b) System.out.println(i);
	    
	    
	    // answer += (Math.pow(10, (Math.log10(b[0]) + 1)) * b[0] + b[0]) * c[0] * c[0];
	    
	    for(int i=0;i<len;i++){
	        for(int j=i+1;j<len;j++){
	            int mult = c[i] * c[j];
	        
	            int size = (int)(Math.log10(b[j]) + 1);
	            answer += (Math.pow(10, size) * b[i] + b[j]) * mult;
	            size = (int)(Math.log10(b[i]) + 1);
	            answer += (Math.pow(10, size) * b[j] + b[i]) * mult;
	            
	        }
	        System.out.println((Math.log10(b[i]) + 1));
	        answer += (Math.pow(10, (int)(Math.log10(b[i]) + 1)) * b[i] + b[i]) * c[i] * c[i];
	    }
	    
	    return answer;
	}

}
