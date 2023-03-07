package softeer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SF_1309 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		long[] total = new long[N];
		for(int n=0;n<3;n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long[] arr = new long[N];
			
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				total[i] += arr[i];
			}
			
			Integer[] arrInt = new Integer[N];
			for(int i=0;i<N;i++) {
				arrInt[i] = (int) arr[i];
			}
			Arrays.sort(arrInt, Collections.reverseOrder());
			HashMap<Integer, Integer> map = new HashMap<>();
			map.put(arrInt[0], 1);
			
			for(int i=1;i<N;i++) {
				if(arrInt[i-1] != arrInt[i]) {
					if(!map.containsKey(arrInt[i])) {
						map.put(arrInt[i], 1+i);
					}
				}
			}
			
			
			for(int i=0;i<N;i++) {
				bw.write(map.get((int) arr[i])+" ");
			}
			bw.write("\n");
			
			
		}
		
		Integer[] arrInt = new Integer[N];
		for(int i=0;i<N;i++) {
			arrInt[i] = (int) total[i];
		}
		Arrays.sort(arrInt, Collections.reverseOrder());
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(arrInt[0], 1);
		
		for(int i=1;i<N;i++) {
			if(arrInt[i-1] != arrInt[i]) {
				if(!map.containsKey(arrInt[i])) {
					map.put(arrInt[i], 1+i);
				}
			}
		}
		
		
		for(int i=0;i<N;i++) {
			bw.write(map.get((int) total[i])+" ");
		}
		bw.write("\n");
		
		bw.flush();
		bw.close();
	}
	
}
