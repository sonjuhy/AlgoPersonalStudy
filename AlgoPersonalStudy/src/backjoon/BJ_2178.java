package backjoon;

import java.io.*;
import java.util.*;

public class BJ_2178 {
    static int[] delta_x = {0,1,0,-1};
    static int[] delta_y = {1,0,-1,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][] distance = new int[N][M];
        distance[0][0] = 1;

        for(int n=0;n<N;n++){
            char[] charArr = br.readLine().toCharArray();
            for(int m=0;m<M;m++){
                map[n][m] = charArr[m] - '0';
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] point = queue.poll();
                for(int d=0;d<4;d++){
                    int dy = point[0] + delta_y[d];
                    int dx = point[1] + delta_x[d];
                    if(dx < 0 || dx >= M || dy < 0 || dy >= N) continue;
                    if(map[dy][dx] == 0) continue;
                    if(distance[dy][dx] != 0) continue;
                    int dis = distance[point[0]][point[1]] + 1;
                    distance[dy][dx] = dis;
                    if(dy == N-1 && dx == M-1){
                        System.out.println(distance[dy][dx]);
                        return;
                    }
                    queue.add(new int[]{dy,dx});
                }
            }
        }
        System.out.println(distance[N-1][M-1]);
    }
}
