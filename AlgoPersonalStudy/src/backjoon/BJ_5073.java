package backjoon;

import java.io.*;
import java.util.*;

public class BJ_5073 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int[] arr = new int[3];
			arr[0] = a;
			arr[1] = b;
			arr[2] = c;
			int max = -1, tmp = 0;
			for(int i=0;i<3;i++) {
				if(tmp < arr[i]) {
					tmp = arr[i];
					max = i;
				}
			}
			
			if(a + b + c == 0) {
				break;
			}
			if(a == b && b == c && a == c) {
				sb.append("Equilateral\n");
			}
			else if(a != b && b != c && a != c) {
				if(arr[max] >= a+b+c - arr[max]) sb.append("Invalid\n");
				else sb.append("Scalene\n");
			}
			else if(a == b || b == c || a == c) {
				sb.append("Isosceles\n");
			}
			else {
				sb.append("Invalid\n");
			}
		}
		System.out.println(sb.toString());
	}

}
