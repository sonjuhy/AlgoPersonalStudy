package programmers;

import java.util.*;

public class PG_12927 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] works = {7,6};
		int n = 3;
		
		Arrays.sort(works);
		
		int before = works[0];
		int count = 1;
		List<int[]> list = new ArrayList<>();
		
        for(int i=1;i<works.length;i++){
        	if(before != works[i]) {
        		list.add(new int[] {before, count});
        		count = 1;
        		before = works[i];
        	}
        	else {
        		count++;
        	}
        }
        list.add(new int[] {works[works.length-1], count});
        
        while(n != 0) {
        	int[] beforeArr = list.get(list.size()-1);
        	if(list.size() == 1) {
        		if(n < list.get(0)[1] * list.get(0)[0]) {
        			int divide = n / list.get(0)[1];
            		int other = n % list.get(0)[1];
        			list.get(0)[0] -= divide;
            		if(other != 0) {
            			list.get(0)[1] -= other;
            			list.add(0, new int[] {list.get(0)[0] - 1, other});
            		}
        			break;
        		}
        		else {
        			System.out.println(0);
        			return;
        		}
        	}
        	else {
        		int size = list.size()-2;
                if(list.size() < 2) size++;
                for(int i=size;i>=0;i--) {
                	int[] tmp = list.get(i);
                	int diffWork = beforeArr[0] - tmp[0];
                	int diffCount = beforeArr[1];
                	if(diffWork * diffCount < n) {
                		n -= diffWork * diffCount;
                		list.get(i)[1] += beforeArr[1];
                		list.remove(i+1);
                		beforeArr = list.get(i);
                	}
                	else if(diffWork * diffCount == n) {
                		list.get(i)[1] += beforeArr[1];
                		list.remove(i+1);
                		beforeArr = list.get(i);
                		n = 0;
                		break;
                	}
                	else {
                		int divide = n / diffCount;
                		int other = n % diffCount;
            			list.get(i+1)[0] = beforeArr[0] - divide;
                		if(other != 0) {
                			list.get(i+1)[1] -= other;
                			list.add(i+1, new int[] {beforeArr[0] - divide - 1, other});
                		}
                		
                		n = 0;
                		break;
                	}
                }
        	}
            
        }
        
        long answer = 0;
        for(int i=0;i<list.size();i++) {
        	answer += Math.pow(list.get(i)[0], 2) * list.get(i)[1];
        }
        System.out.println(answer);
	}

}
