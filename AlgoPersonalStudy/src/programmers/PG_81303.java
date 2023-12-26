package programmers;

import java.util.*;


public class PG_81303 {
    public static void main(String[] args) {
        int n=8, k=2;
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
        String result = solution(n, k, cmd);
        System.out.println(result);
    }
    public static String solution(int n, int k, String[] cmd){
        String answer = "";
        int absPoint = k, lastPoint = n-1;
        Stack<Integer> zStack = new Stack<>();
        List<Integer> deleteList = new ArrayList<>();
        for(String order : cmd){
            if(order.equals("Z")){
                int beforeData = zStack.pop();
                deleteList.remove((Integer) beforeData);
                if(beforeData > lastPoint) lastPoint = beforeData;
            }
            else if(order.equals("C")){
                deleteList.add(absPoint);
                zStack.push(absPoint);
                if(absPoint == lastPoint){
                    if(absPoint > 0) {
                        do {
                            lastPoint--;
                        } while (deleteList.contains(lastPoint));
                        absPoint = lastPoint;
                    }
                    else{
                        absPoint = 0;
                        lastPoint = 0;
                    }
                }
                else{
                    do{
                        absPoint++;
                    } while(deleteList.contains(absPoint));
                }
            }
            else {
                String[] orders = order.split(" ");
                String action = orders[0];
                int place = Integer.parseInt(orders[1]);
                if(action.equals("U")){
                    while(place>0){
                        absPoint--;
                        if(!deleteList.contains(absPoint)) place--;
                    }
                }
                else{
                    while(place>0){
                        absPoint++;
                        if(!deleteList.contains(absPoint)) place--;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            if(deleteList.contains(i)) sb.append("X");
            else sb.append("O");
        }
        answer = sb.toString();
        return answer;
    }
}
