package backjoon;

import java.io.*;
import java.util.*;

public class BJ_19637 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N= Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Confidence[] confArr = new Confidence[N];
		
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			String word = st.nextToken().toString();
			int conf = Integer.parseInt(st.nextToken());
			if(n>0 && confArr[n-1].conf == conf) word = confArr[n-1].word;
			confArr[n] = new Confidence(word, conf);
		}
		StringBuilder sb = new StringBuilder();
		
		for(int m=0;m<M;m++) {
			int point = Integer.parseInt(br.readLine());
			int start = 0;
			int end = N-1;
			while(true) {
				int mid = (start + end)/2;
				if(point < confArr[mid].conf) {
					if(mid > 0 && point > confArr[mid-1].conf) {
						sb.append(confArr[mid].word+"\n");
						break;
					}
					else if(mid == 0) {
						sb.append(confArr[0].word+"\n");
						break;
					}
					else end = mid;
				}
				else if(point > confArr[mid].conf) {
					if(mid < N-1 && point < confArr[mid+1].conf) {
						sb.append(confArr[mid+1].word+"\n");
						break;
					}
					else if(start == N-2 && end == N-1) {
						sb.append(confArr[end].word+"\n");
						break;
					}
					else start = mid;
				}
				else{
					sb.append(confArr[mid].word+"\n");
					break;
				}
			}
		}
		System.out.println(sb.toString());
	}
	static class Confidence{
		String word;
		int conf;
		public Confidence() {}
		public Confidence(String word, int conf) {
			this.word = word;
			this.conf = conf;
		}
	}
}
