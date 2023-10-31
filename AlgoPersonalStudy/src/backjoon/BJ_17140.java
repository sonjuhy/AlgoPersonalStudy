package backjoon;

import java.io.*;
import java.util.*;

public class BJ_17140 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()) - 1;
        int C = Integer.parseInt(st.nextToken()) - 1;
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[101][101];
        for(int i=0;i<3;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int row = 3, col = 3;

        for(int i=0;i<=100;i++){
            if(map[R][C] == K){
                System.out.println(i);
                return;
            }
            PriorityQueue<Number> pq = new PriorityQueue<>();
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            if(row >= col){
                int maxCol = 0;
                for(int r=0;r<row;r++){
                    for(int c=0;c<col;c++){
                        if(map[r][c] == 0) continue;
                        if(hashMap.containsKey(map[r][c])){
                            hashMap.put(map[r][c], hashMap.get(map[r][c])+1);
                        }
                        else{
                            hashMap.put(map[r][c], 1);
                        }
                    }
                    maxCol = Math.max(maxCol, hashMap.size()*2);
                    for(int key : hashMap.keySet()){
                        pq.add(new Number(key, hashMap.get(key)));
                    }
                    Arrays.fill(map[r], 0);

                    int point = 0;
                    while(!pq.isEmpty()){
                        Number num = pq.poll();
                        map[r][point] = num.num;
                        point++;
                        map[r][point] = num.count;
                        point++;
                    }
                    hashMap.clear();
                }
                col = maxCol;
            }
            else{
                int maxRow = 0;
                for(int c=0;c<col;c++){
                    for(int r=0;r<row;r++){
                        if(map[r][c] == 0) continue;
                        if(hashMap.containsKey(map[r][c])){
                            hashMap.put(map[r][c], hashMap.get(map[r][c])+1);
                        }
                        else{
                            hashMap.put(map[r][c], 1);
                        }
                    }
                    maxRow = Math.max(maxRow, hashMap.size()*2);
                    for(int key : hashMap.keySet()){
                        pq.add(new Number(key, hashMap.get(key)));
                    }
//                    Arrays.fill(map[c], 0);
                    for(int f=0;f<101;f++){
                        map[f][c] = 0;
                    }

                    int point = 0;
                    while(!pq.isEmpty()){
                        Number num = pq.poll();
                        map[point][c] = num.num;
                        point++;
                        map[point][c] = num.count;
                        point++;
                    }
                    hashMap.clear();
                }
                row = maxRow;
            }
//            print(row,col,map);
        }
        System.out.println(-1);
    }
    static void print(int row, int col, int[][] map){
        System.out.println();
        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                System.out.print(map[r][c]+" ");
            }
            System.out.println();
        }
    }
    static class Number implements Comparable<Number>{
        int num;
        int count;
        public Number(){}

        public Number(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Number o) {
            if(o.count > this.count){
                return -1;
            }
            else if(o.count < this.count){
                return 1;
            }
            else{
                if(o.num < this.num){
                    return 1;
                }
                else if(o.num > this.num){
                    return -1;
                }
            }
            return 0;
        }
    }
}
