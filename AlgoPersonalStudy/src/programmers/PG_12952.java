package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PG_12952 {
    static int test = 0;
    static int[] arr, saveArr;
    static int[][] numToPoint;
    static HashSet<String> answerSet;
    public static void main(String[] args){
        int n = 12;
        int result = solution(n);
        System.out.println(result);
    }
    public static int solution(int n){
        int answer = 0;
        arr = new int[n*n];
        saveArr = new int[n];
        numToPoint = new int[n*n][2];
        answerSet = new HashSet<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int num = i*n+j;
                arr[num] = num;
                numToPoint[num][0] = i; // y
                numToPoint[num][1] = j; // x
            }
        }
        System.out.println("here");
        combination(0,0, n);
        answer = answerSet.size();
        System.out.println(test);
        return answer;
    }
    static void combination(int start, int dp, int n) {
        if(dp == n) {
            for (int i = 0; i < n; i++) {
                test++;
//                boolean result = overlapCheck(saveArr, n);
//                if(result){
//                    StringBuilder tmp = new StringBuilder();
//                    for(int j=0;j<n;j++) tmp.append(saveArr[j]).append(",");
//                    answerSet.add(tmp.toString());
//                }
            }
            return;
        }
        for (int i = start; i < arr.length; i++) {
            saveArr[dp] = arr[i];
            combination(i+1, dp+1, n);
        }
    }
    public static boolean overlapCheck(int[] points, int n){
        Set<Integer> setX = new HashSet<>();
        Set<Integer> setY = new HashSet<>();
        for(int i=0;i<n;i++){
            setX.add(numToPoint[points[i]][0]);
            setY.add(numToPoint[points[i]][1]);
        }
        boolean result =setX.size() == n && setY.size() == n;
        if(result){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    float dis = (float)(numToPoint[points[i]][0]-numToPoint[points[j]][0]) / (numToPoint[points[i]][1]-numToPoint[points[j]][1]);
                    if(dis == 1 || dis == -1) return false;
                }
            }
            return true;
        }
        else return false;
    }
}

