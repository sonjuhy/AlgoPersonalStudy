package backjoon;

import java.io.*;
import java.util.*;

public class BJ_8979 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Country[] countrys = new Country[N];
		
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int brone = Integer.parseInt(st.nextToken());
			countrys[n] = new Country(num, gold, silver, brone);
		}
		Arrays.sort(countrys);
		
		int answer = 0;
		for(int n=0;n<N;n++) {
			if(!countrys[n].same) {
				if(n > 0 && countrys[n-1].same) answer = n+1;
				else answer++;
			}
			if(countrys[n].num == K) break;
			System.out.println("num : " + countrys[n].num +", same : " + countrys[n].same);
		}
		System.out.println(answer);
	}
	static class Country implements Comparable<Country>{
		int num;
		int gold;
		int sliver;
		int brone;
		boolean same = false;
		public Country() {}
		public Country(int num, int gold, int sliver, int brone) {
			this.num = num;
			this.gold = gold;
			this.sliver = sliver;
			this.brone = brone;
		}
		@Override
		public int compareTo(Country o) {
			// TODO Auto-generated method stub
			if(this.gold < o.gold) {
				return 1;
			}
			else if(this.gold > o.gold) {
				return -1;
			}
			else {
				if(this.sliver < o.sliver) {
					return 1;
				}
				else if(this.sliver > o.sliver) {
					return -1;
				}
				else {
					if(this.brone < o.brone) {
						return 1;
					}
					else if(this.brone > o.brone) {
						return -1;
					}
					else {
						this.same = true;
//						o.same = true;
						return 0;
					}
				}
			}
		}
	}
}
