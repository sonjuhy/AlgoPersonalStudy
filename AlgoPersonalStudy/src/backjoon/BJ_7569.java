package backjoon;

import java.io.*;
import java.util.*;

public class BJ_7569 {
    static int[][][] box;
    static boolean[][][] visited;
    static int[] delta_x = {0,1,0,-1}, delta_y = {1,0,-1,0}, delta_z = {1,-1};
    static int greenPotato, day = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        box = new int[N][M][H];
        visited = new boolean[N][M][H]; // y,x,z

        Queue<int[]> queue = new LinkedList<>();
        for(int h=0;h<H;h++){
            for(int n=0;n<N;n++) {
                st = new StringTokenizer(br.readLine());
                for(int m=0;m<M;m++){
                    box[n][m][h] = Integer.parseInt(st.nextToken());
                    if(box[n][m][h] == 0) greenPotato++;
                    else if(box[n][m][h] == 1) queue.add(new int[]{n,m,h});
                }
            }
        }
        if(!queue.isEmpty()) day--;
        while(!queue.isEmpty()){
            int qSize = queue.size();
            day++;
            for(int q=0;q<qSize;q++){
                int[] point = queue.poll();
                for(int d=0;d<4;d++){
                    int dx = delta_x[d] + point[1];
                    int dy = delta_y[d] + point[0];
                    int dz = point[2];
                    if(dx < 0 || dx >= M || dy < 0 || dy >= N) continue;
                    if(visited[dy][dx][dz]) continue;
                    visited[dy][dx][dz] = true;
                    if(box[dy][dx][dz] != 0) continue;
                    box[dy][dx][dz] = 1;
                    greenPotato--;
                    queue.add(new int[]{dy,dx,dz});
                }
                for(int d=0;d<2;d++){
                    int dx = point[1];
                    int dy = point[0];
                    int dz = delta_z[d] + point[2];
                    if(dz < 0 || dz >= H) continue;
                    if(visited[dy][dx][dz]) continue;
                    visited[dy][dx][dz] = true;
                    if(box[dy][dx][dz] != 0) continue;
                    box[dy][dx][dz] = 1;
                    greenPotato--;
                    queue.add(new int[]{dy,dx,dz});
                }
            }
        }
        if(greenPotato == 0) System.out.println(day);
        else System.out.println(-1);
    }
}
