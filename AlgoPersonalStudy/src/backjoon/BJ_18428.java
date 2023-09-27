package backjoon;

import java.io.*;
import java.util.*;

public class BJ_18428 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		boolean[][] visited = new boolean[N][N];
		List<int[]> teachers = new ArrayList<>();
		
		for(int n=0;n<N;n++) {
			String[] strArr = br.readLine().split(" ");
			for(int m=0;m<N;m++) {
				map[n][m] = strArr[m].charAt(0);
				if(map[n][m] == 'T') {
					int[] tmp = {n,m};
					teachers.add(tmp);
				}
			}
		}
		String answer = "NO";
		int count = 0;
		
		for(int t=0;t<teachers.size();t++) {
			int[] teacher = teachers.get(t);
			if(teacher[0] == 0 ) {
				if(map[1][teacher[1]] == 'S') {
					System.out.println("NO");
					return;
				}
				for(int n=1;n<N;n++) {
					if(map[n][teacher[1]] == 'X') {
						visited[n][teacher[1]] = true;
					}
					else if(map[n][teacher[1]] == 'S') {
						count++;
						break;
					}
				}
			}
			else if(teacher[0] == N-1) {
				if(map[N-2][teacher[1]] == 'S') {
					System.out.println("NO");
					return;
				}
				for(int n=N-1;n>=0;n--) {
					if(map[n][teacher[1]] == 'X') {
						visited[n][teacher[1]] = true;
					}
					else if(map[n][teacher[1]] == 'S') {
						count++;
						break;
					}
				}
			}
			else {
				if(map[teacher[0]+1][teacher[1]] == 'S' || map[teacher[0]-1][teacher[1]] == 'S') {
					System.out.println("NO");
					return;
				}
				for(int n=teacher[0]-1;n>=0;n--) {
					if(map[n][teacher[1]] == 'X') {
						visited[n][teacher[1]] = true;
					}
					else if(map[n][teacher[1]] == 'S') {
						count++;
						break;
					}
				}
				
				for(int n=teacher[0]+1;n<N;n++) {
					if(map[n][teacher[1]] == 'X') {
						visited[n][teacher[1]] = true;
					}
					else if(map[n][teacher[1]] == 'S') {
						count++;
						break;
					}
				}
				
			}
		}
		
		for(int t=0;t<teachers.size();t++) {
			int[] teacher = teachers.get(t);
			if(teacher[1] == 0 ) {
				if(map[teacher[0]][1] == 'S') {
					System.out.println("NO");
					return;
				}
				boolean overlap = false;
				for(int n=1;n<N;n++) {
					if(map[teacher[0]][n] == 'X') {
						if(!visited[teacher[0]][n]) visited[teacher[0]][n] = true;
						else overlap = true;
					}
					else if(map[teacher[0]][n] == 'S') {
						if(!overlap) count++;
						break;
					}
				}
			}
			else if(teacher[1] == N-1) {
				if(map[teacher[0]][N-2] == 'S') {
					System.out.println("NO");
					return;
				}
				boolean overlap = false;
				for(int n=N-1;n>=0;n--) {
					if(map[teacher[0]][n] == 'X') {
						if(!visited[teacher[0]][n]) visited[teacher[0]][n] = true;
						else overlap = true;
					}
					else if(map[teacher[0]][n] == 'S') {
						if(!overlap) count++;
						break;
					}
				}
			}
			else {
				if(map[teacher[0]][teacher[1]+1] == 'S' || map[teacher[0]][teacher[1]-1] == 'S') {
					System.out.println("NO");
					return;
				}
				boolean overlap = false;
				for(int n=teacher[1]-1;n>=0;n--) {
					if(map[teacher[0]][n] == 'X') {
						if(!visited[teacher[0]][n]) visited[teacher[0]][n] = true;
						else overlap = true;
					}
					else if(map[teacher[0]][n] == 'S') {
						if(!overlap) count++;
						break;
					}
				}
				overlap = false;
				for(int n=teacher[1]+1;n<N;n++) {
					if(map[teacher[0]][n] == 'X') {
						if(!visited[teacher[0]][n]) visited[teacher[0]][n] = true;
						else overlap = true;
					}
					else if(map[teacher[0]][n] == 'S') {
						if(!overlap) count++;
						break;
					}
				}
				
			}
		}
		if(count <= 3) answer = "YES";
		System.out.println(answer);
	}

}
