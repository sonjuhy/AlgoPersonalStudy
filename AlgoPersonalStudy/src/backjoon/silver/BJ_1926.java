package backjoon.silver;

import java.util.*;
import java.io.*;
public class BJ_1926 {

    static int[] delta_x = {0,1,0,-1}, delta_y = {1,0,-1,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        int count = 0, maxSize = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j] == 1){
                    if(!visited[i][j]) {
                        count++;
                        int tmpSize = 1;

                        visited[i][j] = true;
                        queue.add(new int[]{i,j});
                        while(!queue.isEmpty()){
                            int[] tmp = queue.poll();
                            for(int d=0;d<4;d++){
                                int dy = tmp[0] + delta_y[d];
                                int dx = tmp[1] + delta_x[d];
                                if(dy >= 0 && dy < n && dx >=0 && dx < m){
                                    if(map[dy][dx] == 1 && !visited[dy][dx]){
                                        visited[dy][dx] = true;
                                        tmpSize++;
                                        queue.add(new int[]{dy,dx});
                                    }
                                }
                            }
                        }
                        maxSize = Math.max(maxSize, tmpSize);
                    }
                }
            }
        }
        System.out.println(count);
        System.out.println(maxSize);
    }
}
