package programmers;

import java.util.HashMap;

public class PG_67258_unsolved {
    public static void main(String[] args) {
        String[] gems = {};
        int[] result = solution(gems);
        System.out.println(result);
    }
    public static int[] solution(String[] gems){
        int[] answer = {};
        int len = answer.length;
        HashMap<String, Boolean> hashMap = new HashMap<>();
        for(String gem: gems) hashMap.put(gem, false);
        int start = 0, end = len, gemCount = hashMap.size();
        while(start <= end){
            int tmpGemCount = 0, tmpEndPoint = 0;
            for(int i=start;i<end;i++){
                if(!hashMap.get(gems[i])){
                    tmpGemCount++;
                    hashMap.put(gems[i], true);
                }
                if(tmpGemCount >= gemCount){
                    tmpEndPoint = i;
                    break;
                }
            }

        }

        return answer;
    }
}
