package programmers;

import java.util.*;

public class PG_12987 {
    public static void main(String[] args) {
        int[] A = {5,1,3,7};
        int[] B = {2,2,6,8};

        int result = solution(A, B);
        System.out.println(result);
    }
    public static int solution(int[] A, int[] B){
        int answer = 0;
        PriorityQueue<Integer> pqA = new PriorityQueue<>();
        PriorityQueue<Integer> pqB = new PriorityQueue<>();
        int len = A.length;

        for(int i=0;i<len;i++){
            pqA.add(A[i]);
            pqB.add(B[i]);
        }
        while(!pqA.isEmpty()){
            if(pqB.size() == 0) break;
            int a = pqA.poll();
            while(!pqB.isEmpty()){
                int b = pqB.poll();
                if(a < b){
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
