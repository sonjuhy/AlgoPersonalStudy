package leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LC_969909824 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		reverseString(br.readLine().toCharArray());
	}
	public static void reverseString(char[] s) {
        int len = s.length;
        for(int i=0;i<len/2;i++){
            char tmp = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = tmp;
        }
    }
}
