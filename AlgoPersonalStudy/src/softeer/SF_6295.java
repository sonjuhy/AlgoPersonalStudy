package softeer;

import java.io.*;
import java.util.*;

public class SF_6295 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int n=0;n<N;n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            System.out.println("Case #"+(n+1)+": "+(A+B));
        }
    }
}
