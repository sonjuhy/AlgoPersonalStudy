package backjoon.silver;

import java.io.*;
import java.util.*;

public class BJ_1822 {
    public static void main(String[] args) throws Exception {
        solution();
    }
    static void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        HashSet<Long> hashSet = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int a=0;a<A;a++){
            long num = Long.parseLong(st.nextToken());
            hashSet.add(num);
        }

        st = new StringTokenizer(br.readLine());
        for(int b=0;b<B;b++){
            long num = Long.parseLong(st.nextToken());
            hashSet.remove(num);
        }
        if(hashSet.isEmpty()){
            System.out.println(0);
        }
        else {
            System.out.println(hashSet.size());
            ArrayList<Long> list = new ArrayList<>(hashSet);
            Collections.sort(list);

            StringBuilder sb = new StringBuilder();
            for (long num : list) {
                sb.append(num).append(" ");
            }
            System.out.println(sb.toString());
        }
    }
}
