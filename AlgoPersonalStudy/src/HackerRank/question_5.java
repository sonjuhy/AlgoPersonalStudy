package HackerRank;

import java.io.*;
import java.util.*;

public class question_5 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		List<Integer> list = new ArrayList<>();
//		for(int n=0;n<N;n++) {
//			list.add(Integer.parseInt(br.readLine()));
//		}
//		List<Integer> copy = new ArrayList<>(list);
//		Collections.sort(copy);
//		System.out.println(copy.get(0));
//		
////		for(int l : list)System.out.println(l);
//		
//		int q = Integer.parseInt(br.readLine());
//		List<Integer> queries = new ArrayList<>();
//		
//		for(int n=0;n<q;n++) {
////			queries.add(Integer.parseInt(br.readLine()));
//			int string =Integer.parseInt(br.readLine());
//			queries.add(string);
//		}
//		System.out.println("q size : " + q);
//		System.out.println(predictAnswer(list, queries));
	}
	public static List<Integer> predictAnswer(List<Integer> stockData, List<Integer> queries) {
	    // Write your code here
		List<Integer> answer = new ArrayList<>();
        
        for(int query : queries){
        	 int order = 1, move = 0;
             int day = -1;
             int stock = stockData.get(query-1);
             
             int count = 0, moveCount = 0;
             while(count < stockData.size()-1) {
                 if((moveCount&1)==0) move++;
                 order *= -1;
                 
                 moveCount++;
                 
                 int nextDay = move * order + query - 1;
                 if(nextDay < 0 || nextDay >= stockData.size()) continue;
                 int tmpStock = stockData.get(nextDay);
                 System.out.println("tmpStock : " + tmpStock+ ", nextDay : " + nextDay);
                 if(tmpStock < stock) {
                     day = nextDay+1;
                     break;
                 }
                 count++;
             }
             System.out.println();
             answer.add(day);
        }
        return answer;
	    }
}
