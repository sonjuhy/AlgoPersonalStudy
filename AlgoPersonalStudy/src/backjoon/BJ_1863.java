package backjoon;

import java.io.*;
import java.util.*;

public class BJ_1863 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		int answer = 0;
		
		for(int n=0;n<N;n++) {
			String[] strArr = br.readLine().split(" ");
			int height = Integer.parseInt(strArr[1]);
			while(!stack.isEmpty()) {
				if(stack.peek() > height) {
					answer++;
					stack.pop();
				}
				else {
					break;
				}
			}
			if(!stack.isEmpty() && stack.peek() == height) continue;
			stack.push(height);
		}
		System.out.println(answer);
	}
}
