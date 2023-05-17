package backjoon;

import java.io.*;
import java.util.*;

public class BJ_25757 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		String M = st.nextToken();
		int people = 0;
		
		
		HashMap<String, Integer> hashMap = new HashMap<>();
		for(int n=0;n<N;n++) {
			String name = br.readLine();
			if(!hashMap.containsKey(name)) {
				hashMap.put(name, 1);
			}
		}
		int count = hashMap.size();
		int answer = 0;
		switch(M) {
		case "Y":
			people = 1;
			break;
		case "F":
			people = 2;
			break;
		case "O":
			people = 3;
			break;
		}
		answer = count / people;
		System.out.println(answer);
	}

}
