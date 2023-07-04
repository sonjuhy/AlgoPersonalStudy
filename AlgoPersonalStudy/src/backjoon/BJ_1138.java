package backjoon;

import java.io.*;
import java.util.*;

public class BJ_1138 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[] answer = new int[N];
		for(int n=0;n<N;n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		answer[arr[0]] = 1;
		for(int n=1;n<N;n++) {
			if(arr[n] == 0) {
				for(int m=0;m<N;m++) {
					if(answer[m] == 0) {
						answer[m] = n+1;
						break;
					}
				}
			}
			else {
				for(int m=0;m <= arr[n];m++) {
					if(answer[n+m] == 0) {
						answer[n+m] = n+1;
						break;
					}
				}
			}
		}
		for(int num : answer) {
			System.out.print(num+" ");
		}
	}

}
