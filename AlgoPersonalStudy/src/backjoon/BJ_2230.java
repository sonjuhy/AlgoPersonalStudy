package backjoon;

import java.io.*;
import java.util.*;

public class BJ_2230 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            if(hashMap.containsKey(num)) {
                if(hashMap.get(num)){
                    hashMap.put(num, false);
                    list.add(num);
                }
            }
            else{
                hashMap.put(num, true);
                list.add(num);
            }
        }
        int[] arr = list.stream().mapToInt(i->i).toArray();
        Arrays.sort(arr);
        int minCount = Integer.MAX_VALUE;
        int start = 0, end = 0, arrLen = arr.length;
        while(start < arrLen && end < arrLen){
            int diff = arr[end] - arr[start];
            if(diff < M){
                end++;
            }
            else {
                minCount = Math.min(diff, minCount);
                start++;
            }
        }
        System.out.println(minCount);
    }
}
