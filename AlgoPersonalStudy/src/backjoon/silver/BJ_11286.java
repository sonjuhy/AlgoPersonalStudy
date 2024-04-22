package backjoon.silver;

import java.util.*;
import java.io.*;

public class BJ_11286 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<n;i++){
            int x = Integer.parseInt(br.readLine());
            if (x == 0){
                if(!pq.isEmpty()) {
                    int[] polledData = pq.poll();
                    sb.append(polledData[1]).append("\n");
                }
                else{
                    sb.append(0).append("\n");
                }
            }
            else {
                pq.add(new int[]{Math.abs(x),x});
            }
        }
        System.out.println(sb.toString());
    }
}
