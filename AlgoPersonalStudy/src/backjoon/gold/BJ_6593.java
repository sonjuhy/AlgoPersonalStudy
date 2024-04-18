package backjoon.gold;

import java.io.*;
import java.util.*;

public class BJ_6593 {

    static int[] delta_x = {0, 1, 0, -1}, delta_y = {1, 0, -1, 0}, delta_z = {1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if(L ==R && L ==C && L==0){
                break;
            }

            char[][][] building = new char[L][R][C];
            int[][][] time = new int[L][R][C];
            boolean[][][] visited = new boolean[L][R][C];

            int[] start = new int[3], end = new int[3]; // z,y,x

            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    char[] tmp = br.readLine().toCharArray();
                    for(int c=0;c<C;c++){
                        building[l][r][c] = tmp[c];
                        if(tmp[c]  == 'S'){
                            start[0] = l;
                            start[1] = r;
                            start[2] = c;
                        }
                        else if(tmp[c] == 'E'){
                            end[0] = l;
                            end[1] = r;
                            end[2] = c;
                        }
                    }
                }
                br.readLine();
            }

            int count = 0;
            visited[start[0]][start[1]][start[2]] = true;

            Queue<int[]> queue = new LinkedList<>();
            queue.add(start);
            while(!queue.isEmpty()){
                int queueSize = queue.size();
                count++;

                for(int q=0;q<queueSize;q++){
                    int[] point = queue.poll();
                    int z = point[0];
                    int y = point[1];
                    int x = point[2];

                    for(int d=0;d<4;d++){
                        int dy = delta_y[d] + y;
                        int dx = delta_x[d] + x;
                        if(dy < 0 || dy >= R ||dx < 0 || dx >= C) continue;
                        if(building[z][dy][dx] == '#') continue;
                        if(!visited[z][dy][dx]){
                            visited[z][dy][dx] = true;
                            time[z][dy][dx] = count;
                            queue.add(new int[]{z, dy, dx});
                        }
                    }
                    for(int d=0;d<2;d++){
                        int dz = delta_z[d] + z;
                        if(dz < 0 || dz >= L) continue;
                        if(building[dz][y][x] == '#') continue;
                        if(!visited[dz][y][x]){
                            visited[dz][y][x] = true;
                            time[dz][y][x] = count;
                            queue.add(new int[]{dz, y, x});
                        }
                    }
                }

            }

            int goal = time[end[0]][end[1]][end[2]];
            if(goal == 0){
                System.out.println("Trapped!");
            }
            else{
                System.out.println("Escaped in "+goal+" minute(s).");
            }
        }
    }
}
