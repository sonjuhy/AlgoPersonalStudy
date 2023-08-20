package backjoon;

import java.io.*;
import java.util.*;

public class BJ_4659 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<Character, Boolean> hashMap = new HashMap<>();
		hashMap.put('a', true);
		hashMap.put('e', true);
		hashMap.put('i', true);
		hashMap.put('o', true);
		hashMap.put('u', true);
		
		while(true) {
			String word = br.readLine();
			if(word.equals("end"))break;
			boolean case1 = false, case2 = true, case3 = true;
			int case2Count = 0, case3Count1 = 0, case3Count2 = 0;
			
			char[] wordArr = word.toCharArray();
			char before = wordArr[0];
			if(hashMap.containsKey(before)) case1 = true;
			for(int i=1;i<wordArr.length;i++) {
				if(hashMap.containsKey(wordArr[i])) {
					case1 = true;
					if(hashMap.containsKey(before)) case3Count1++;
					else case3Count1 = 0;
				}
				else {
					if(!hashMap.containsKey(before)) case3Count2++;
					else case3Count2 = 0;
				}
				if(case3Count1 >= 2 || case3Count2 >= 2) {
					case3 = false;
					break;
				}
				if(before == wordArr[i]) {
					case2Count++;
					if(case2Count >= 1 && !(before == 'e' || before == 'o')) {
						case2 = false;
						break;
					}
				}
				else case2Count = 0;
				before = wordArr[i];
				
			}
			sb.append("<"+word+"> is ");
			if(case1 && case2 && case3) {
				sb.append("acceptable.\n");
			}
			else {
				sb.append("not acceptable.\n");
			}
		}
		System.out.println(sb.toString());
	}

}
