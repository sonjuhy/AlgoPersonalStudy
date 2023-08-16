package backjoon;

import java.io.*;

public class BJ_20125 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		
		int mode = 0, heartX = -1, heartY = -1, leftLegX = -1, rightLegX = -1;
		int waist = 0, leftArm = 0, rightArm = 0, leftLeg = 0, rightLeg = 0;
		for(int n=0;n<N;n++) {
			map[n] = br.readLine().toCharArray();
			int starCount = 0;
			if(mode > 2) {
				if(map[n][leftLegX] == '*') leftLeg++;
				if(map[n][rightLegX] == '*') rightLeg++;
			}
			else {
				for(int m=0;m<N;m++) {
					switch(mode) {
					case 0:
						if(map[n][m] == '*') {
							heartY = m+1;
							heartX = n+2;
							mode++;
							m = N;
						}
						break;
					case 1:
						if(map[n][m] == '*') {
							if(m < heartY-1) leftArm++;
							else if(m > heartY-1) rightArm++;
						}
						if(m == N-1) mode++;
						break;
					case 2:
						if(map[n][m] == '*') {
							starCount++;
							if(starCount == 1) leftLegX = m;
							else rightLegX = m;
						}
						if(starCount > 1) {
							waist = n - heartX;
							leftLeg++;
							rightLeg++;
							mode++;
						}
						break;
					}
				}
			}
		}
		System.out.println(heartX+" "+heartY);
		System.out.println(leftArm+" "+rightArm+" "+waist+" "+leftLeg+" "+rightLeg);
	}

}
