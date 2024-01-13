package backjoon;

import java.io.*;
import java.util.*;

public class BJ_14582 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] one = new int[9];
        for(int i=0;i<9;i++){
            one[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] two = new int[9];
        for(int i=0;i<9;i++){
            two[i] = Integer.parseInt(st.nextToken());
        }
        int oneSum = 0, twoSum = 0;
        boolean jemiWin = false;
        for(int i=0;i<9;i++){
            oneSum += one[i];
            if(oneSum > twoSum) {
                jemiWin = true;
                break;
            }
            twoSum += two[i];
        }
        if(jemiWin) System.out.println("Yes");
        else System.out.println("No");
    }
}
