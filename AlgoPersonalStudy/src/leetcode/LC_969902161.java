package leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LC_969902161 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(isPalindrome(br.readLine()));

	}
	public static boolean isPalindrome(String s) {
        String str = s.replaceAll("[^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]", "").toLowerCase();
        char[] chars = str.toCharArray();
        for(int i=0;i<str.length()/2;i++){
            if(chars[i] != chars[str.length()-i-1])
            return false;
        }
        return true;
    }
}
