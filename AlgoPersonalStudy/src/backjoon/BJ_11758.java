package backjoon;

import java.io.*;
import java.util.*;

public class BJ_11758 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] line = new int[3][2];
        for(int i=0;i<3;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            line[i][0] = x;
            line[i][1] = y;
        }
        int ccw = (line[0][0] * line[1][1] + line[1][0] * line[2][1] + line[2][0] * line[0][1])
                - (line[1][0] * line[0][1] + line[2][0] * line[1][1] + line[0][0] * line[2][1]);
        if(ccw == 0) System.out.println(0);
        else if(ccw < 0) System.out.println(-1);
        else System.out.println(1);
    }
}
