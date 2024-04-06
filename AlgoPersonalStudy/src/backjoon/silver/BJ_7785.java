package backjoon.silver;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BJ_7785 {
    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        HashSet<String> people = new HashSet<>();
        for(int n=0;n<N;n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String action = st.nextToken();
            if("enter".equals(action)){
                people.add(name);
            }
            else{
                people.remove(name);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String person : people.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())) {
            sb.append(person).append("\n");
        }
        System.out.println(sb.toString());
    }
}
