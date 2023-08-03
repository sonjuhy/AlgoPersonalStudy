package backjoon;

import java.io.*;
import java.util.*;

public class BJ_7682 {
	
	static char[][] map = new char[3][3];
	static List<Integer> nullList = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String str = br.readLine();
			if(str.equals("end")) {
				break;
			}
			char[] arr = str.toCharArray();
			
			for(int i=0;i<9;i++) {
				map[i/3][i%3] = arr[i];
				if(arr[i] == '.') {
					nullList.add(i);
				}
			}
			if(nullList.size() == 0) {
				sb.append("valid\n");
			}
			else {
				boolean result = calc(1, 0, true);
				if(result) sb.append("valid\n");
				else sb.append("invalid\n");
				nullList.clear();
			}
		}
		System.out.println(sb.toString());
	}
	public static boolean calc(int deps, int point, boolean order) {
		boolean rowO=false, colO=false, diaO=false;
		boolean rowX=false, colX=false, diaX=false;
		boolean answer = false;
		
		if(nullList.size() > 0) {
			int place = nullList.get(point);
			if(order) map[place/3][place%3] = 'X';
			else map[place/3][place%3] = 'O';
		}
		// row
		for(int i=0;i<3;i++) {
			boolean tmpO = true, tmpX = true;
			for(int j=1;j<3;j++) {
				if(map[i][j-1] != map[i][j]) {
					tmpO = false;
					tmpX = false;
					break;
				}
			}
			if(tmpO && map[i][0] == 'O') rowO = tmpO;
			if(tmpX && map[i][0] == 'X') rowX = tmpX;
		}
		// col
		for(int i=0;i<3;i++) {
			boolean tmpO = true, tmpX = true;
			for(int j=1;j<3;j++) {
				if(map[j-1][i] != map[j][i]) {
					tmpO = false;
					tmpX = false;
					break;
				}
			}
			if(tmpO && map[i][0] == 'O') colO = tmpO;
			if(tmpX && map[i][0] == 'X') colX = tmpX;
		}
		// dia
		for(int i=1;i<3;i++) {
			boolean tmpO = true, tmpX = true;;
			if(map[i-1][i-1] != map[i][i]) {
				tmpO = false;
				tmpX = false;
				break;
			}
			if(tmpO && map[i][0] == 'O') diaO = tmpO;
			if(tmpX && map[i][0] == 'X') diaX = tmpX;
		}
		for(int i=1;i<3;i++) {
			boolean tmpO = true, tmpX = true;;
			if(map[i-1][i-1] != map[i][2-i]) {
				tmpO = false;
				tmpX = false;
				break;
			}
			if(tmpO && map[i][2] == 'O') diaO = tmpO;
			if(tmpX && map[i][2] == 'X') diaX = tmpX;
		}
		
		if(rowO && colO && diaO) answer = true;
		if(rowX && colX && diaX) answer = true;
		
		if(!answer && deps < nullList.size()){
			if(point+1 < nullList.size()) {
				int place = nullList.get(point);
				map[place/3][place%3] = '.';
				answer = calc(deps, point+1, order);
			}
			else answer = calc(deps+1, 0, !order);
		}
	
		return answer;
	}
}
