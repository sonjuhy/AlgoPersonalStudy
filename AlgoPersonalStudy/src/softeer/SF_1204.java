package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SF_1204 {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int n=0;n<N;n++) {
			int key = Integer.parseInt(st.nextToken());
			if(map.containsKey(key)) {
				map.put(key, map.get(key)+1);
			}
			else {
				map.put(key, 1);
			}
		}
		Computer[] computers = new Computer[map.size()];
		
		int keyCount = 0;
		for(int key : map.keySet()) {
			computers[keyCount] = new Computer(key, map.get(key));
			keyCount++;
		}
		
		long level = (long) (Math.pow(10, 9)/2);
		int mapSize = map.size();
		
		while(true) {
			long tmpCost = 0;
			
			for(int l=0;l<mapSize;l++) {
				if(computers[l].num >= level) {
					break;
				}
				tmpCost += computers[l].count * Math.pow((level - computers[l].num),2);
				
			}
			if(tmpCost < B) {
				level += level / 2;
			}
			else if(tmpCost > B) {
				level = level / 2;
			}
			else {
				break;
			}
		}

		System.out.println(level-1);
	}
	
	static class Computer {
		int num;
		int count;
		Computer(int num, int count){
			this.num = num;
			this.count = count;
		}
	}
}
