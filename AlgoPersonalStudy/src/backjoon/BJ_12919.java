package backjoon;

import java.io.*;

public class BJ_12919 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		if(calcMin(T,S)) System.out.println(1);
		else System.out.println(0);
	}
	static boolean calcMin(String str, String s) {
		if(str.length() == s.length()) {
			if(str.equals(s)) return true;
			else return false;
		}
		boolean result = false;
		char[] strChar = str.toCharArray();
		if(strChar[strChar.length-1] == 'A') {
			result = calcMin(str.substring(0, strChar.length-1), s);
			if(result) return true;
		}
		if(strChar[0] == 'B') {
			StringBuffer sb = new StringBuffer(str);
			String reverse = sb.reverse().toString();
			result = calcMin(reverse.substring(0, strChar.length-1), s);
			if(result) return true;
		}
		return result;
	}
}
