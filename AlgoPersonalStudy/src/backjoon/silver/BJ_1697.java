package backjoon.silver;

import java.io.*;
import java.util.*;

public class BJ_1697 {
    static int MAX_LEN = 100001;
    static int[] delta = {-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if(n == k){
            System.out.println(0);
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        int[] map = new int[MAX_LEN];
        Arrays.fill(map, Integer.MAX_VALUE);
        int day = 0;

        queue.add(new int[]{0,n});
        while(!queue.isEmpty()){
            day++;
            int[] now = queue.poll();
            int dx = now[1] + 1;
            if(dx < MAX_LEN){
                if(day < map[dx]){
                    map[dx] = day;
                    queue.add(new int[]{day, dx});
                }
            }
            dx = now[1] - 1;
            if(dx >= 0){
                if(day < map[dx]){
                    map[dx] = day;
                    queue.add(new int[]{day, dx});
                }
            }
            dx = now[1] * 2;
            if(dx < MAX_LEN){
                if(day < map[dx]){
                    map[dx] = day;
                    queue.add(new int[]{day, dx});
                }
            }
        }

        System.out.println(map[k]);
    }
}
