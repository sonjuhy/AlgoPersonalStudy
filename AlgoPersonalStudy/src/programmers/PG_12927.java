package programmers;

import java.util.*;

public class PG_12927 {

	public static void main(String[] args) {
		int n = 4;
		int[] works = {4,3,3};
		long result = solution(n, works);
		System.out.println(result);
	}
	public static long solution(int n, int[] works){
		long answer = 0;
		Arrays.sort(works);
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(works[0],1);
		int lenWorks = works.length;

		for(int i=1;i<lenWorks;i++){
			int work = works[i];
			if(work != works[i-1]){
				hashMap.put(work, 1);
			}
			else{
				hashMap.replace(work, hashMap.get(work)+1);
			}
		}
		PriorityQueue<Work> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int key : hashMap.keySet()){
			pq.add(new Work(key, hashMap.get(key)));
		}
		while(n > 0 && !pq.isEmpty()){
			Work work = pq.poll();
			if(work.count < n){
				if(work.work > 1){
					if(!pq.isEmpty()){
						Work nextWork = pq.poll();
						if(nextWork.work == work.work - 1){
							nextWork.count += work.count;
						}
						else{
							work.work -= 1;
							pq.add(work);
						}
						pq.add(nextWork);
						n -= work.count;
					}
					else{
						work.work--;
						n -= work.count;
						pq.add(work);
					}
				}
				else{
					n -= work.count;
				}
			}
			else if(work.count > n){
				if(!pq.isEmpty()) {
					work.count -= n;
					Work nextWork = pq.poll();
					if(nextWork.work == work.work-1){
						nextWork.count += n;
					}
					else{
						pq.add(new Work(work.work-1, n));
					}
					pq.add(work);
					pq.add(nextWork);
					n = 0;
				}
				else{
					if(work.work > 1){
						pq.add(new Work(work.work-1, work.count - n));
					}
					work.count -= n;
					n = 0;
					pq.add(work);
				}
			}
			else{
				if(!pq.isEmpty()) {
					Work nextWork = pq.poll();
					if(nextWork.work == work.work - 1) {
						nextWork.count += n;
					}
					else{
						work.work--;
						pq.add(work);
					}
					pq.add(nextWork);
				}
				else{
					if(work.work > 1){
						work.work--;
						pq.add(work);
					}
				}
				n = 0;
			}
		}
		if(n > 0) answer = 0;
		else{
			while(!pq.isEmpty()){
				Work work = pq.poll();
				long tired = (long) Math.pow(work.work,2) * work.count;
				answer += tired;
			}
		}
		return answer;
	}
	static class Work implements Comparable<Work>{
		int work;
		int count;
		public Work(int work, int count){
			this.work = work;
			this.count = count;
		}

		@Override
		public int compareTo(Work o) {
			if(work < o.work) return -1;
			else if(work > o.work) return 1;
			return 0;
		}
	}
}
