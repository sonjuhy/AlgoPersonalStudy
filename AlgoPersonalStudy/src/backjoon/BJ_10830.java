package backjoon;

import java.io.*;
import java.util.*;

public class BJ_10830 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		long map[][] = new long[N][N];
		long[][] result;
		
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			for(int n2=0;n2<N;n2++) {
				map[n][n2] = Integer.parseInt(st.nextToken());
			}
		}
		result = map.clone();
		
		Stack<long[][]> matrixs = new Stack<>();
		while(B > 0) {
			if((B&1) == 1) {
				matrixs.push(result);
			}
			if(B > 1) {
				long tmpMap[][] = new long[N][N];
				for(int n=0;n<N;n++) {
					for(int m=0;m<N;m++) {
						for(int c=0;c<N;c++) {
							tmpMap[n][m] += result[n][c] * result[c][m];
						}
						if(tmpMap[n][m] > 1000) tmpMap[n][m] = tmpMap[n][m] % 1000;
					}
				}
				result = tmpMap;
			}
			B = B >> 1;
		}
		
		result = matrixs.pop();
		for(long[][] matrix : matrixs) {
			long tmpMap[][] = new long[N][N];
			for(int n=0;n<N;n++) {
				for(int m=0;m<N;m++) {
					for(int c=0;c<N;c++) {
						tmpMap[n][m] += result[n][c] * matrix[c][m];
					}
					tmpMap[n][m] = tmpMap[n][m] % 1000;
				}
			}
			result = tmpMap;
		}
		
		for(int n=0;n<N;n++) {
			for(int m=0;m<N;m++) {
				result[n][m] = result[n][m] % 1000;
				System.out.print(result[n][m] + " ");
			}
			System.out.println();
		}
	}
}
