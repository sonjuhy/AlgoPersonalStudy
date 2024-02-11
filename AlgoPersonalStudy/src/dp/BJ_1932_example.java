package dp;

import java.io.*;
import java.util.*;

public class BJ_1932_example {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] triangle = new int[N][];
        for(int i=0;i<N;i++){
            triangle[i] = new int[i+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<i+1;j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = example(N, triangle);
        System.out.println(answer);
    }
    public static int example(int N, int[][] triangle){
        int answer = 0;
        for(int n=N-1;n>=0;n--){
            for(int i=0;i<triangle[n].length-1;i++){
                triangle[n-1][i] += Math.max(triangle[n][i], triangle[n][i+1]);
            }
        }
        answer = triangle[0][0];
        return answer;
    }
}
