package backjoon;

import java.io.*;
import java.util.*;

public class BJ_1157 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] sizes = new int[26];
		char[] arr = br.readLine().toUpperCase().toCharArray();
		for(int i=0;i<arr.length;i++) {
			sizes[arr[i]-65]++;
		}
		int max = 0, same = 0, point = -1;
		for(int i=0;i<26;i++) {
			if(max < sizes[i]) {
				max = sizes[i];
				same = 1;
				point = i;
			}
			else if(max == sizes[i]) {
				same++;
			}
		}
		if(same > 1) {
			System.out.println("?");
		}
		else {
			System.out.println((char)(point+65));
		}
	}

}
