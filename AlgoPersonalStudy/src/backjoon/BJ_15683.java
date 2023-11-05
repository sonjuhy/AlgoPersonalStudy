package backjoon;

import java.io.*;
import java.util.*;

public class BJ_15683 {
    static int N,M, maxCount = Integer.MAX_VALUE;
    static HashMap<Integer, List<int[]>> hashMap = new HashMap<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] typeArr = new int[6];
        int[][] map = new int[N][M];
        for(int n=0;n<N;n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0;m<M;m++){
                map[n][m] = Integer.parseInt(st.nextToken());
                if(map[n][m] != 0 && map[n][m] != 6){
                    typeArr[map[n][m]]++;
                    if(hashMap.containsKey(map[n][m])){
                        hashMap.get(map[n][m]).add(new int[]{n, m});
                    }
                    else{
                        List<int[]> list = new ArrayList<>();
                        list.add(new int[]{n, m});
                        hashMap.put(map[n][m], list);
                    }
                }
            }
        }

        for(int five=0;five<typeArr[5];five++){
            for(int[] point :  hashMap.get(5)){
                for(int i=1;i<5;i++){
                    draw(i, point[1], point[0], map);
                }
            }
        }
        DFS(map, typeArr, 4);
        System.out.println(maxCount);
    }
    static void DFS(int[][] map, int[] typeArr, int deps){
        if(deps == 0){
            int tmpCount = 0;
            for(int n=0;n<N;n++){
                for(int m=0;m<M;m++){
                    System.out.print(map[n][m]+" ");
                    if(map[n][m] == 0) tmpCount++;
                }
                System.out.println();
            }
            System.out.println();
            maxCount = Math.min(maxCount, tmpCount);
            return;
        }
        if(typeArr[deps] == 0) {
            DFS(map, typeArr, deps-1);
            return;
        }
        switch (deps){
            case 4:
                for(int[] point : hashMap.get(deps)){
                    for(int i=1;i<5;i++){
                        int[][] tmpMap = mapCopy(map);
                        draw(i, point[1], point[0], tmpMap);
                        draw((i+2)%4, point[1], point[0], tmpMap);
                        draw((i+3)%4, point[1], point[0], tmpMap);
                        DFS(tmpMap, typeArr, deps-1);
                    }
                }
                break;
            case 3:
                for(int[] point : hashMap.get(deps)){
                    for(int i=1;i<5;i++){
                        int[][] tmpMap = mapCopy(map);
                        draw(i, point[1], point[0], tmpMap);
                        draw((i+2)%4, point[1], point[0], tmpMap);
                        DFS(tmpMap, typeArr, deps-1);
                    }
                }
                break;
            case 2:
                for(int[] point : hashMap.get(deps)){
                    for(int i=1;i<5;i++){
                        int[][] tmpMap = mapCopy(map);
                        draw((i+1)%4, point[1], point[0], tmpMap);
                        draw((i+3)%4, point[1], point[0], tmpMap);
                        DFS(tmpMap, typeArr, deps-1);
                    }
                }
                break;
            case 1:
                for(int[] point : hashMap.get(deps)){
                    for(int i=1;i<5;i++){
                        int[][] tmpMap = mapCopy(map);
                        draw(i, point[1], point[0], tmpMap);
                        DFS(tmpMap, typeArr, 0);
                    }
                }
                break;
        }
    }
    static void draw(int dir, int x, int y, int[][] map){
        switch(dir){
            case 1: // up
                for(int i=y-1;i>=0;i--){
                    if(map[i][x] == 6) break;
                    if(map[i][x] != 0) continue;
                    map[i][x] = -1;
                }
                break;
            case 2: // down
                for(int i=y+1;i<N;i++){
                    if(map[i][x] == 6) break;
                    if(map[i][x] != 0) continue;
                    map[i][x] = -1;
                }
                break;
            case 3: // right
                for(int i=x+1;i<M;i++){
                    if(map[y][i] == 6) break;
                    if(map[y][i] != 0) continue;
                    map[y][i] = -1;
                }
                break;
            case 4: // left
                for(int i=x-1;i>=0;i--){
                    if(map[y][i] == 6) break;
                    if(map[y][i] != 0) continue;
                    map[y][i] = -1;
                }
                break;
        }
    }
    static int[][] mapCopy(int[][] map){
        int[][] copyMap = new int[N][M];
        for(int n=0;n<N;n++){
            for(int m=0;m<M;m++){
                copyMap[n][m] = map[n][m];
            }
        }
        return copyMap;
    }
}
