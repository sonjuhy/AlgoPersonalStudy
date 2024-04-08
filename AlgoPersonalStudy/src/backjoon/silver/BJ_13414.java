package backjoon.silver;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BJ_13414 {
    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> students = new HashMap<>();

        for(int l=0;l<L;l++){
            String num = br.readLine();
            if(students.containsKey(num)){
                students.replace(num, l);
            }
            else{
                students.put(num, l);
            }
        }

        StringBuilder sb = new StringBuilder();
        List<Map.Entry<String, Integer>> list = students.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        int count = 0;
        for(Map.Entry<String, Integer> student : list){
            count++;
            sb.append(student.getKey()).append("\n");
            if(count == K) break;
        }
        System.out.println(sb.toString());
    }
}
