package backjoon.silver;

import java.io.*;
import java.util.*;

public class BJ_1764 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> nameSet = new HashSet<>();
        for(int n=0;n<N;n++){
            String name = br.readLine();
            nameSet.add(name);
        }
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int m=0;m<M;m++){
            String name = br.readLine();
            if(nameSet.contains(name)){
                list.add(name);
            }
        }
        int pqSize = list.size();
        Collections.sort(list);
        for(String name : list){
            sb.append(name).append("\n");
        }
        System.out.println(pqSize);
        System.out.println(sb.toString());
//        PriorityQueue<String> pq = new PriorityQueue<>();
//        StringBuilder sb = new StringBuilder();
//        for(int m=0;m<M;m++){
//            String name = br.readLine();
//            if(nameSet.contains(name)){
//                pq.add(name);
//            }
//        }
//        int pqSize = pq.size();
//        for(String name : pq){
//            sb.append(name).append("\n");
//        }
//        System.out.println(pqSize);
//        System.out.println(sb.toString());
    }
}
