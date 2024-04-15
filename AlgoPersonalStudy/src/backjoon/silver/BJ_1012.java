package backjoon.silver;

import java.util.*;
import java.io.*;

public class BJ_1012 {

    static int[] delta_x = {0,1,0,-1}, delta_y = {1,0,-1,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][M];
            boolean[][] visited = new boolean[N][M];

            for(int k=0;k<K;k++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            Queue<int[]> queue = new LinkedList<>();
            int answer = 0;

            for(int n=0;n<N;n++){
                for(int m=0;m<M;m++){
                    if(map[n][m] == 1){
                        if(!visited[n][m]){
                            visited[n][m] = true;
                            answer++;
                            queue.add(new int[]{n,m});
                            while(!queue.isEmpty()){
                                int[] tmp = queue.poll();
                                for(int d=0;d<4;d++){
                                    int dy = tmp[0] + delta_y[d];
                                    int dx = tmp[1] + delta_x[d];
                                    if(dy >= 0 && dy < N && dx >=0 && dx < M){
                                        if(map[dy][dx] == 1 && !visited[dy][dx]){
                                            visited[dy][dx] = true;
                                            queue.add(new int[]{dy,dx});
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
