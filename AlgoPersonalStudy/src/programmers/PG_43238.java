package programmers;

import java.util.Arrays;

public class PG_43238 {
    public static void main(String[] args) {
        int n = 7;
        int[] times = {10,10};
        long result = solution(n, times);
        System.out.println(result);
    }
    public static long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        int len = times.length;
        Arrays.sort(times);
        long start = times[0];
        long end = times[len-1] * (long)n;
        long mid;
        long sum = 0;
        while(start <= end){
            mid = (start + end)/2;
            sum = 0;
            for(int time : times){
                sum += mid / time;
            }
            if(sum >= n){
                answer = Math.min(answer, mid);
                end = mid - 1;
            }
            else{
                start = mid+1;
            }
        }
        return answer;
    }
}
