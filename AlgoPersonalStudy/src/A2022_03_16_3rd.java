import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A2022_03_16_3rd {
	static long count=0;
	static long answer = 0;
	static long N = 0;
	public static void main(String[] args) throws Exception{
		//System.out.println((long)Math.pow(3, 10));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(br.readLine());
		
		long etc = 0;
		while(true) {
			if((long)Math.pow(2, count+1) == N) {
				count++;
				break;
			}
			else if((long)Math.pow(2, count) <= N && (long)Math.pow(2, count+1) > N) {
				break;
			}
			count++;
		}
		
		bit(count+1,(long)Math.pow(2, count));
		System.out.println(answer);
		answer = 0;
	}
	 static void bit(long n, long start) {
	        for (long i = start; i < 1 << n; i++) {
	            for (long j = 0; j < n; j++) { 
	                if ((i & 1 << j) != 0 ) {
	                	if(i == N) {
	                		answer += (long) Math.pow(3, j);
	                	}
	                }
	            }
	        }
	    }
}
