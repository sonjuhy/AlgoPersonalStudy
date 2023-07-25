package backjoon;

import java.io.*;
import java.util.*;

public class BJ_10431 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<Integer> arr = new ArrayList<>();
			sb.append((Integer.parseInt(st.nextToken()))+" ");
			for(int i=0;i<20;i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			int answer = 0;
			for(int p = 1;p<20;p++) {
				int num = arr.get(p);
				int point = -1;
				for(int f=p-1;f>=0;f--) {
					if(num < arr.get(f)) {
						point = f;
					}
				}
				
				if(point >= 0) {
					if(point>0) {
						arr.remove(p);
						arr.add(point-1, num);
						answer += 19 - point;
					}
					else {
						arr.remove(p);
						arr.add(0, num);						
						answer += 19;
					}
					System.out.println(point+", "+answer);
					p = 1;
				}
			}
			System.out.println("");
			sb.append(answer+"\n");
		}
		System.out.println(sb.toString());
	}

}
