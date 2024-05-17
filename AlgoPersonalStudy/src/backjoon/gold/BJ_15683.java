package backjoon.gold;

import java.io.*;
import java.util.*;

public class BJ_15683 {
    static int N, M, shadedCount = 0, answer = Integer.MAX_VALUE;
    static int[] cctvDir;
    static int[][] map;
    static List<int[]> cctvList = new ArrayList<>(); // arr[type, y, x]

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int n=0;n<N;n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0;m<M;m++){
                int num = Integer.parseInt(st.nextToken());
                map[n][m] = num;
                if(num > 0) {
                    if (num < 6) {
                        cctvList.add(new int[]{num, n, m});
                    }
                    shadedCount++;
                }
            }
        }
        cctvDir = new int[cctvList.size()];
        comb(0, cctvList.size());
        System.out.println(answer);
    }
    static void comb(int dep, int num){
        if(dep == num){
            int[][] localMap = new int[N][M];
            for(int n=0;n<N;n++){
                localMap[n] = map[n].clone();
            }
            int localShadedCount = 0;
            for(int idx=0;idx<cctvList.size();idx++){
                int[] cctv = cctvList.get(idx);
                switch (cctv[0]){
                    case 1:
                        switch (cctvDir[idx]){
                            case 0: // up
                                localShadedCount += searchDyUp(localMap, cctv);
                                break;
                            case 1: // right
                                localShadedCount += searchDxRight(localMap, cctv);
                                break;
                            case 2: // down
                                localShadedCount += searchDyDown(localMap, cctv);
                                break;
                            case 3: // left
                                localShadedCount += searchDxLeft(localMap, cctv);
                                break;
                        }
                        break;
                    case 2:
                        switch (cctvDir[idx]){
                            case 0: // up & down
                                localShadedCount += searchDyUp(localMap, cctv);
                                localShadedCount += searchDyDown(localMap, cctv);
                                break;
                            case 1: // right & left
                                localShadedCount += searchDxRight(localMap, cctv);
                                localShadedCount += searchDxLeft(localMap, cctv);
                                break;
                        }
                        break;
                    case 3:
                        switch (cctvDir[idx]){
                            case 0: // up & right
                                localShadedCount += searchDyUp(localMap, cctv);
                                localShadedCount += searchDxRight(localMap, cctv);
                                break;
                            case 1: // right & down
                                localShadedCount += searchDxRight(localMap, cctv);
                                localShadedCount += searchDyDown(localMap, cctv);
                                break;
                            case 2: // down & left
                                localShadedCount += searchDyDown(localMap, cctv);
                                localShadedCount += searchDxLeft(localMap, cctv);
                                break;
                            case 3: // left & up
                                localShadedCount += searchDyUp(localMap, cctv);
                                localShadedCount += searchDxLeft(localMap, cctv);
                                break;
                        }
                        break;
                    case 4:
                        switch (cctvDir[idx]){
                            case 0: // up & right & left
                                localShadedCount += searchDyUp(localMap, cctv);
                                localShadedCount += searchDxRight(localMap, cctv);
                                localShadedCount += searchDxLeft(localMap, cctv);
                                break;
                            case 1: // right & up & down
                                localShadedCount += searchDyUp(localMap, cctv);
                                localShadedCount += searchDyDown(localMap, cctv);
                                localShadedCount += searchDxRight(localMap, cctv);
                                break;
                            case 2: // down & right & left
                                localShadedCount += searchDyDown(localMap, cctv);
                                localShadedCount += searchDxRight(localMap, cctv);
                                localShadedCount += searchDxLeft(localMap, cctv);
                                break;
                            case 3: // left & up & down
                                localShadedCount += searchDyUp(localMap, cctv);
                                localShadedCount += searchDyDown(localMap, cctv);
                                localShadedCount += searchDxLeft(localMap, cctv);
                                break;
                        }
                        break;
                    case 5:
                        localShadedCount += searchDyUp(localMap, cctv);
                        localShadedCount += searchDyDown(localMap, cctv);
                        localShadedCount += searchDxRight(localMap, cctv);
                        localShadedCount += searchDxLeft(localMap, cctv);
                        break;
                }
            }
//            System.out.println(Arrays.toString(cctvDir)+", unShaded area : " + (N*M - localShadedCount - shadedCount));
//            printMap(localMap);
            answer = Math.min(answer, (N*M - localShadedCount - shadedCount));
        }
        else{
            int[] cctv = cctvList.get(dep);
            switch(cctv[0]){
                case 1:
                case 3:
                case 4:
                    for(int d=0;d<4;d++){
                        cctvDir[dep] = d;
                        comb(dep+1, num);
                    }
                    break;
                case 2:
                    for(int d=0;d<2;d++){
                        cctvDir[dep] = d;
                        comb(dep+1, num);
                    }
                    break;
                case 5:
                    comb(dep+1, num);
                    break;
            }
        }
    }
    static int searchDyUp(int[][] localMap, int[] cctv){
        int localShadedCount = 0;
        int dyUp = cctv[1]-1;
        while(dyUp >= 0){
            if(localMap[dyUp][cctv[2]] == 0){
                localMap[dyUp][cctv[2]] = -1;
                localShadedCount++;
                dyUp--;
            }
            else if(localMap[dyUp][cctv[2]] != 6) dyUp--;
            else break;
        }
        return localShadedCount;
    }
    static int searchDyDown(int[][] localMap, int[] cctv){
        int localShadedCount = 0;
        int dyDown = cctv[1]+1;
        while(dyDown < N){
            if(localMap[dyDown][cctv[2]] == 0){
                localMap[dyDown][cctv[2]] = -1;
                localShadedCount++;
                dyDown++;
            }
            else if(localMap[dyDown][cctv[2]] != 6) dyDown++;
            else break;
        }
        return localShadedCount;
    }
    static int searchDxRight(int[][] localMap, int[] cctv){
        int localShadedCount = 0;
        int dxRight = cctv[2]+1;
        while(dxRight < M){
            if(localMap[cctv[1]][dxRight] == 0){
                localMap[cctv[1]][dxRight] = -1;
                localShadedCount++;
                dxRight++;
            }
            else if(localMap[cctv[1]][dxRight] != 6) dxRight++;
            else break;
        }
        return localShadedCount;
    }
    static int searchDxLeft(int[][] localMap, int[] cctv){
        int localShadedCount = 0;
        int dxLeft = cctv[2]-1;
        while(dxLeft >= 0){
            if(localMap[cctv[1]][dxLeft] == 0){
                localMap[cctv[1]][dxLeft] = -1;
                localShadedCount++;
                dxLeft--;
            }
            else if(localMap[cctv[1]][dxLeft] != 6) dxLeft--;
            else break;
        }
        return localShadedCount;
    }
    static void printMap(int[][] localMap){
        for(int n=0;n<N;n++){
            for(int m=0;m<M;m++){
                System.out.print(localMap[n][m] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
//public class BJ_15683 {
//    static int N,M, maxCount = Integer.MAX_VALUE;
//    static HashMap<Integer, List<int[]>> hashMap = new HashMap<>();
//
//    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        int[] typeArr = new int[6];
//        int[][] map = new int[N][M];
//        for(int n=0;n<N;n++){
//            st = new StringTokenizer(br.readLine());
//            for(int m=0;m<M;m++){
//                map[n][m] = Integer.parseInt(st.nextToken());
//                if(map[n][m] != 0 && map[n][m] != 6){
//                    typeArr[map[n][m]]++;
//                    if(hashMap.containsKey(map[n][m])){
//                        hashMap.get(map[n][m]).add(new int[]{n, m});
//                    }
//                    else{
//                        List<int[]> list = new ArrayList<>();
//                        list.add(new int[]{n, m});
//                        hashMap.put(map[n][m], list);
//                    }
//                }
//            }
//        }
//
//        for(int five=0;five<typeArr[5];five++){
//            for(int[] point :  hashMap.get(5)){
//                for(int i=1;i<5;i++){
//                    draw(i, point[1], point[0], map);
//                }
//            }
//        }
//        DFS(map, typeArr, 4);
//        System.out.println(maxCount);
//    }
//    static void DFS(int[][] map, int[] typeArr, int deps){
//        if(deps == 0){
//            int tmpCount = 0;
//            for(int n=0;n<N;n++){
//                for(int m=0;m<M;m++){
//                    System.out.print(map[n][m]+" ");
//                    if(map[n][m] == 0) tmpCount++;
//                }
//                System.out.println();
//            }
//            System.out.println();
//            maxCount = Math.min(maxCount, tmpCount);
//            return;
//        }
//        if(typeArr[deps] == 0) {
//            DFS(map, typeArr, deps-1);
//            return;
//        }
//        switch (deps){
//            case 4:
//                for(int[] point : hashMap.get(deps)){
//                    for(int i=1;i<5;i++){
//                        int[][] tmpMap = mapCopy(map);
//                        draw(i, point[1], point[0], tmpMap);
//                        draw((i+2)%4, point[1], point[0], tmpMap);
//                        draw((i+3)%4, point[1], point[0], tmpMap);
//                        DFS(tmpMap, typeArr, deps-1);
//                    }
//                }
//                break;
//            case 3:
//                for(int[] point : hashMap.get(deps)){
//                    for(int i=1;i<5;i++){
//                        int[][] tmpMap = mapCopy(map);
//                        draw(i, point[1], point[0], tmpMap);
//                        draw((i+2)%4, point[1], point[0], tmpMap);
//                        DFS(tmpMap, typeArr, deps-1);
//                    }
//                }
//                break;
//            case 2:
//                for(int[] point : hashMap.get(deps)){
//                    for(int i=1;i<5;i++){
//                        int[][] tmpMap = mapCopy(map);
//                        draw((i+1)%4, point[1], point[0], tmpMap);
//                        draw((i+3)%4, point[1], point[0], tmpMap);
//                        DFS(tmpMap, typeArr, deps-1);
//                    }
//                }
//                break;
//            case 1:
//                for(int[] point : hashMap.get(deps)){
//                    for(int i=1;i<5;i++){
//                        int[][] tmpMap = mapCopy(map);
//                        draw(i, point[1], point[0], tmpMap);
//                        DFS(tmpMap, typeArr, 0);
//                    }
//                }
//                break;
//        }
//    }
//    static void draw(int dir, int x, int y, int[][] map){
//        switch(dir){
//            case 1: // up
//                for(int i=y-1;i>=0;i--){
//                    if(map[i][x] == 6) break;
//                    if(map[i][x] != 0) continue;
//                    map[i][x] = -1;
//                }
//                break;
//            case 2: // down
//                for(int i=y+1;i<N;i++){
//                    if(map[i][x] == 6) break;
//                    if(map[i][x] != 0) continue;
//                    map[i][x] = -1;
//                }
//                break;
//            case 3: // right
//                for(int i=x+1;i<M;i++){
//                    if(map[y][i] == 6) break;
//                    if(map[y][i] != 0) continue;
//                    map[y][i] = -1;
//                }
//                break;
//            case 4: // left
//                for(int i=x-1;i>=0;i--){
//                    if(map[y][i] == 6) break;
//                    if(map[y][i] != 0) continue;
//                    map[y][i] = -1;
//                }
//                break;
//        }
//    }
//    static int[][] mapCopy(int[][] map){
//        int[][] copyMap = new int[N][M];
//        for(int n=0;n<N;n++){
//            for(int m=0;m<M;m++){
//                copyMap[n][m] = map[n][m];
//            }
//        }
//        return copyMap;
//    }
//}
