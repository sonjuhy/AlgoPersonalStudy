package etc;

import java.io.*;
import java.util.*;

public class buildblock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,3,4,5};
		int[] answer = new int[4];
		
		// 1.
		for(int i=arr.length;i>=0;i--) {
			answer[4-i] = arr[i];
			System.out.print(answer[4-i]+" ");
		}
		System.out.println();
		// 2.
		int sum = 0, zeroCount = 0;
		for(int i=0;i<4;i++) {
			if(arr[i] != 0) sum *= arr[i];
			else zeroCount++;
		}
		StringBuilder sb = new StringBuilder();
		if(zeroCount < 2) {
			for(int i=0;i<4;i++) {
				if(arr[i] == 0) {
					sb.append("0 ");
					continue;
				}
				sb.append((sum / arr[i])+"");
			}
		}
		else {
			for(int i=0;i<4;i++) {
				sb.append("0 ");
			}
		}
		System.out.println(sb.toString());
		// 3.
		// hint:
		// [1,3,4,5]
		// [2,1,4,5]
		// [2,3,1,5]
		// [2,3,4,1]
		
	}

}
