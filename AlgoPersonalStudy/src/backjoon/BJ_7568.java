package backjoon;

import java.io.*;
import java.util.*;

public class BJ_7568 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] answer = new int[N];
		Person[] people = new Person[N];
		
		for(int n=0;n<N;n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			people[n] = new Person(x,y);
		}
		for(int n=0;n<N;n++) {
			for(int m=0;m<N;m++) {
				if(m == n) continue;
				if(people[n].height > people[m].height && people[n].weight > people[m].weight) {
					answer[m]++;
				}
			}
		}
		for(int n=0;n<N;n++) System.out.print((answer[n]+1)+" ");
		System.out.println();
	}
	static class Person{
		int weight;
		int height;
		public Person() {}
		public Person(int weight, int height) {
			this.weight = weight;
			this.height = height;
		}
	}

}
