package backjoon;

import java.io.*;
import java.util.*;

public class BJ_1911 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		List<Water> waterList = new ArrayList<>();
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			waterList.add(new Water(s,e,e-s));
		}
		waterList.sort(Comparator.naturalOrder());
		
		int place = 0, answer = 0;
		for(Water water : waterList) {
			int tmpLen = water.len;
			if(place > water.start) tmpLen -= place - water.start;
			answer += tmpLen / L;
			place = water.end;
			if(tmpLen % L != 0) {
				place += (L - (tmpLen % L));
				answer++;
			}
		}
		System.out.println(answer);
	}
	static class Water implements Comparable<Water>{
		int start;
		int end;
		int len;
		public Water() {};
		public Water(int start, int end, int len) {
			this.start = start;
			this.end = end;
			this.len = len;
		}
		@Override
		public int compareTo(Water o) {
			// TODO Auto-generated method stub
			if(this.start > o.start) {
				return 1;
			}
			else if(this.start < o.start) {
				return -1;
			}
			return 0;
		}
		
	}
}
