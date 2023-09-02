package backjoon;

import java.io.*;
import java.util.*;

public class BJ_9527 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		long A = Long.parseLong(strs[0]);
		long B = Long.parseLong(strs[1]);
		
		int aCount = 0, bCount = 0;
		Stack<Integer> aStack = new Stack<>();
		Stack<Integer> bStack = new Stack<>();
		while(A != 0) {
			aStack.push((int) (A&1));
			A = A >> 1;
		}
		while(B == 0) {
			bStack.push((int) (A&1));
			B = B >> 1;
		}
		
		int stackSize = aStack.size()-1;
		for(int n=stackSize; n>=0; n--) {
			int num = aStack.pop();
			if(num == 1) {
				for(int i=n;i>0;i--) {
					if(i > 1) aCount += (int) ((2 + (i-1))*Math.pow(2, i-2));
					else aCount += 1;
				}
				aCount += 1;
			}
		}

		System.out.println(aCount+", ");

	}
}
