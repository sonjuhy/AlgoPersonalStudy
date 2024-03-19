package programmers;

import java.util.Arrays;

public class PG_12941 {
    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b = {3,4};
        int answer = solution(a,b);
        System.out.println(answer);
    }

    public static int solution(int[] A, int[] B){
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;
        for(int i=0;i<A.length;i++){
            answer += (A[i] * B[A.length-1-i]);
        }
        return answer;
    }
}
