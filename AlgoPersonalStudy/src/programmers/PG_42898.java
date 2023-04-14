package programmers;

import java.io.*;

public class PG_42898 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[][] puddles = new int[][] {{2,2}};
		solution(m,n, puddles);
	}
	public static int solution(int m, int n, int[][] puddles) {
		int answer = 0;
        int divNum = 1000000007;
        
        int[][] map = new int[n][m];
        
        for(int[] place : puddles){
            map[place[1]-1][place[0]-1] = -1;
        }
        for(int i=1;i<m;i++){
            if(map[0][i] == -1 || map[0][i-1] == -1) map[0][i] = -1;
            else map[0][i] = 1;
            
        }
        for(int j=1;j<n;j++){
            if(map[j][0] == -1 || map[j-1][0] == -1) map[j][0] = -1;
            else map[j][0] = 1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(map[i][j] != -1){
                    int a=0,b=0;
                    if(map[i][j-1] != -1) a = map[i][j-1];
                    if(map[i-1][j] != -1) b = map[i-1][j];
                    if(a+b == 0) map[i][j] = -1;
                    else map[i][j] = (a+b) % divNum;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        if(map[n-1][m-1] == -1) return 0;
        return map[n-1][m-1];
	}
}
