package backjoon;

import java.io.*;
import java.util.*;

public class BJ_14891 {

	static char[][] chains = new char[4][8]; // 0 : N, 1: S
	static int[] chainTop = new int[4];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<4;i++) {
			chains[i] = br.readLine().toCharArray();
		}
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int k=0;k<K;k++) {
			st = new StringTokenizer(br.readLine());
			int chainNum = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken()); // 1 : right, -1 : left
			int[] tmpChains = new int[4];
			
			tmpChains[chainNum] = dir*-1;
			boolean turn = true;
			for(int t1=chainNum-1;t1>=0;t1--) {
				if(chains[t1][(chainTop[t1]+2)%8] != chains[t1+1][(chainTop[t1+1]+6)%8] && turn) {
					if((t1 & 1) == (chainNum & 1)) { // same dir, Odd
						tmpChains[t1] = dir*-1;
					}
					else { // Even
						tmpChains[t1] = dir;
					}
				}
				else turn = false;
			}
			turn = true;
			for(int t2=chainNum+1;t2<4;t2++) {
				if(chains[t2][(chainTop[t2]+6)%8] != chains[t2-1][(chainTop[t2-1]+2)%8] && turn) {
					if((t2 & 1) == (chainNum & 1)) { // same dir, Odd
						tmpChains[t2] = dir*-1;
					}
					else { //Even
						tmpChains[t2] = dir;
					}
				}
				else turn = false;
			}
			for(int i=0;i<4;i++) {
				chainTop[i] = (chainTop[i] + 8 + tmpChains[i]) % 8;
			}
		}
		
		int answer = 0;
		for(int i=0;i<4;i++) {
			if(chains[i][chainTop[i]] == '1') {
				answer += Math.pow(2, i);
			}
		}
		System.out.println(answer);
	}
	
}
