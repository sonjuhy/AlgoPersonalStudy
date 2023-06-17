package backjoon;

import java.io.*;
import java.util.*;

public class BJ_10844 {
	static int[] data = {9,17,32,61,118,231,456,905,1802,3595,7180,14349,28686,57359,114704,229393,458770,917523,1835028,3670037,7340054,14680087,29360152,58720281,117440538,234881051,469762076,939524125,879048222,758096415,516192800,32385569,64771106,129542179,259084324,518168613,36337190,72674343,145348648,290697257,581394474,162788907,325577772,651155501,302310958,604621871,209243696,418487345,836974642,673949235,347898420,695796789,391593526,783186999,566373944,132747833,265495610,530991163,61982268,123964477,247928894,495857727,991715392,983430721,966861378,933722691,867445316,734890565,469781062,939562055,879124040,758248009,516495946,32991819,65983564,131967053,263934030,527867983,55735888,111471697,222943314,445886547,891773012,783545941,567091798,134183511,268366936,536733785,73467482,146934875,293869660,587739229,175478366,350956639,701913184,403826273,807652450,615304803,230609508,461218917};
	
	static int[] sample = {1,2,3,4,5,6,7,8,9};
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		for(int s : sample) queue.add(s);
		int round = 0, inRound = 0;
		int N = 2;
		for(int n=0;n<N;n++) {
			int qSize = queue.size();
			for(int q=0;q<qSize;q++) {
				int num = queue.poll();
				int up = num + 1;
				int down = num - 1;
				if((up % 10) != 0) queue.add(up);
				if((down % 10) != 0) queue.add(down);
			}
			if(n == N-1) {
				for(int num : queue) {
					int div = num % 10;
					if(div == 0 || div == 9) round++;
					else if(div == 1 || div == 8) inRound++;
				}
			}
		}
		System.out.println("round : " + round + ", inRound : " + inRound);
//		for(int N=1;N<=100;N++) {
//		int answer = 9;
//		int sum = 7, count = 8;
//		for(int n=2;n<=N;n++) {
//			answer = (count+answer) % 1000000000;
//			count = (sum+count) % 1000000000;
//			sum = (2 * sum) % 1000000000;
//		}
//		System.out.println(answer);
//		if(data[N-1] != answer) {
//			System.out.println(N+", "+answer+" was error");
//		}
//		}
	}

}
