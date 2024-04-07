package programmers;

import java.util.Arrays;

public class PG_12911 {
    public static void main(String[] args) {
        int n = 15;
        for(int i=0;i<100;i++){
            String binaryStr = Integer.toBinaryString(i);
            System.out.println(i+" : "+binaryStr.replaceAll("0", "").length());
        }
//        int answer = solution(n);
//        System.out.println(answer);
    }

    public static int solution(int n){
        int answer = 0;
        int oneCount = 0;
        String binaryStr = Integer.toBinaryString(n);
        oneCount = binaryStr.replaceAll("0", "").length();
        while(true){
            n++;
            String tmpStr = Integer.toBinaryString(n);
            int tmpCount = tmpStr.replaceAll("0", "").length();
            if(oneCount == tmpCount) {
                answer = n;
                break;
            }
        }
        return answer;
    }
}
