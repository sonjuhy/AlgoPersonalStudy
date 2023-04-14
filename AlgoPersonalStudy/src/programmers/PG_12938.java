package programmers;

import java.io.*;
import java.util.*;

public class PG_12938 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int s = Integer.parseInt(br.readLine());
		int[] answer = solution(n,s);
		System.out.println("Answer 1");
		for(int ans : answer) {
			System.out.print(ans+" ");
		}
		System.out.println();
		System.out.println("Answer 2");
		answer = solution2(n,s);
		for(int ans : answer) {
			System.out.print(ans+" ");
		}
	}
	public static int[] solution2(int n, int s) {
		if (n > s) return new int[] {-1};
        int count = 0;
        int arr[] = new int[n];
        while(n >0){
            int value = s/n;
            arr[count++] = value;
            s -= value;
            n--;
        }
        return arr;
	}
	public static int[] solution(int n, int s) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.add(s);
        while(true){
            int quSize = queue.size();
            for(int q=0;q<quSize;q++){
            	if(queue.size() == n){
                    int[] evenAnswer = new int[n];
                    for(int i=n-1;i>=0;i--) evenAnswer[i] = queue.poll();
                    return evenAnswer;
                }
            	
                int num = queue.poll();
                if((num & 1) == 1){
                    if(num != 1){
                        queue.add(num/2);
                        queue.add(num/2+1);    
                        
                    }
                    else{
                        int[] evenAnswer = new int[1];
                        evenAnswer[0] = -1;
                        return evenAnswer;
                    }
                }
                else{
                	int halfNum = num / 2;
                    queue.add(halfNum);
                    queue.add(halfNum);
                }    
            }
            if(queue.size() == n){
                break;
            }
        }
        int[] answer = new int[n];
        for(int q=n-1;q>=0;q--){
            answer[q] = queue.poll();
        }
        
        return answer;
	}
}
