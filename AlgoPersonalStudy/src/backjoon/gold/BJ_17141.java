package backjoon.gold;

import java.io.*;
import java.util.*;
public class BJ_17141 {
    static int N = 0, voidCount = 0, answer = Integer.MAX_VALUE;
    static int[] deltaX = {1, 0, -1, 0}, deltaY = {0,1,0,-1};
    static int[][] map;
    static boolean success = false;
    static boolean[] checkedVirus;
    static List<int[]> virus = new ArrayList<>();;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        int virusCount = 0;
        for(int n=0;n<N;n++){
            st = new StringTokenizer(br.readLine());
            for(int n2=0;n2<N;n2++){
                int num = Integer.parseInt(st.nextToken());
                map[n][n2] = num;
                if(num == 2) {
                    virus.add(new int[]{n,n2});
                    virusCount++;
                }
                else if(num == 1) voidCount++;
            }
        }

        if(voidCount == N*N) System.out.println(0);
        else {
            checkedVirus = new boolean[virusCount];
            getPosition(virusCount, 0, 0, M);
            System.out.println(success ? answer : -1);
        }
    }
    static void getPosition(int virusCount, int start, int dep, int position){
        if(position == dep){
            int checkedPosition = 0;
            int[] virusPosition = new int[position];
            for(int i=0;i<checkedVirus.length;i++){
                if(checkedVirus[i]){
                    virusPosition[checkedPosition++] = i;
                }
            }
            if(BFS(virusPosition)) success = true;
        }
        else{
            for(int i=start;i<virusCount;i++){
                if(!checkedVirus[i]){
                    checkedVirus[i] = true;
                    getPosition(virusCount, i+1, dep+1, position);
                    checkedVirus[i] = false;
                }
            }
        }
    }
    static boolean BFS(int[] virusPosition){
        Queue<int[]> labs = new LinkedList<>();
        int count = -1;
        boolean success = false;
        boolean[][] visited = new boolean[N][N];

        for(int index : virusPosition){
            int[] tmpPosition = virus.get(index);
            labs.add(tmpPosition);
        }

        while(!labs.isEmpty()){
            int qLen = labs.size();
            boolean working = false;
            for(int l=0;l<qLen;l++){
                int[] point = labs.poll();
                if(!visited[point[0]][point[1]]){
                    visited[point[0]][point[1]] = true;
                    working = true;
                    for (int d = 0; d < 4; d++) {
                        int dx = deltaX[d] + point[1];
                        int dy = deltaY[d] + point[0];
                        if (dx < 0 || dx >= N || dy < 0 || dy >= N) continue;
                        if (visited[dy][dx] || map[dy][dx] == 1) continue;
                        labs.add(new int[]{dy, dx});
                    }
                }
            }
            if(working) count++;
        }
        if(checkSuccess(visited)) {
            success = true;
            answer = Math.min(answer, count);
        }
        return success;
    }
    static boolean checkSuccess(boolean[][] lab){
        int tmpCount = 0;
        for(boolean[] col : lab){
            for(boolean row : col){
                if(!row) tmpCount++;
            }
        }
        return tmpCount == voidCount;
    }
}
