package programmers;

import java.io.*;
import java.util.*;

public class PG_43162 {
    public static void main(String[] args) throws Exception {
        int n = 3;
        int[][] computer = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        int result = solution(n, computer);
        System.out.println(result);
    }
    public static int solution(int n, int[][] computers){
        int answer = 0, count = n;
        boolean[] network = new boolean[n];
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(computers[i][j] == 1){
                    if(hashMap.containsKey(i)){
                        if(!hashMap.get(i).contains(j)) hashMap.get(i).add(j);
                    }
                    else{
                        List<Integer> tmpList = new ArrayList<>();
                        tmpList.add(j);
                        hashMap.put(i, tmpList);
                    }
                    if(hashMap.containsKey(j)){
                        if(!hashMap.get(j).contains(i)) hashMap.get(j).add(i);
                    }
                    else{
                        List<Integer> tmp2List = new ArrayList<>();
                        tmp2List.add(i);
                        hashMap.put(j, tmp2List);
                    }
                }
            }
        }
        while(count > 0){
            Queue<Integer> queue = new LinkedList<>();
            int num = 0;
            for(boolean b : network){
                if(!b) break;
                num++;
            }
            network[num] = true;
            count--;
            for(int computer : hashMap.get(num)){
                queue.add(computer);
            }
            while(!queue.isEmpty()) {
                int qSize = queue.size();
                for (int q = 0; q < qSize; q++) {
                    int computer = queue.poll();
                    if (network[computer]) continue;
                    network[computer] = true;
                    count--;
                    for (int netComputer : hashMap.get(computer)) if (!network[netComputer]) queue.add(netComputer);

                }
            }
            answer++;
        }
        return answer;
    }
}
