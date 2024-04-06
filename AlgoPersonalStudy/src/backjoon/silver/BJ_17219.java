package backjoon.silver;

import java.io.*;
import java.util.*;

public class BJ_17219 {
    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> passwordMap = new HashMap<>();
        for(int n=0;n<N;n++){
            st = new StringTokenizer(br.readLine());
            passwordMap.put(st.nextToken(), st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for(int m=0;m<M;m++){
            sb.append(passwordMap.get(br.readLine())).append("\n");
        }
        System.out.println(sb.toString());
    }
}
