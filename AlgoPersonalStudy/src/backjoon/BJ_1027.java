package backjoon;

import java.io.*;
import java.util.*;

public class BJ_1027 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		for(int n=0;n<N;n++) {
			int tmp = 0;
			if(n>0) {
				for(int i=n-1;i>=0;i--) {
					double deg = (double)(arr[i] - arr[n])/(i-n);
					boolean check = true;
					for(int j=i+1;j<n;j++) {
						if(Double.compare(deg*(j-n), (double)(arr[j] - arr[n])) <= 0) {
							check = false;
							break;
						}
					}
					if(check) tmp++;
				}
			}
			if(n < N-1) {
				for(int i=n+1;i<N;i++) {
					double deg = (double)(arr[i] - arr[n])/(i-n);
					boolean check = true;
					for(int j=n+1;j<i;j++) {
						if(Double.compare(deg*(j-n), (double)(arr[j] - arr[n])) <= 0) {
							check = false;
							break;
						}
					}
					if(check) tmp++;
				}
			}
			answer = Math.max(answer, tmp);
		}
		System.out.println(answer);
	}

}
