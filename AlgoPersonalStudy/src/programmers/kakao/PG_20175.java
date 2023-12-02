package programmers.kakao;

import java.util.*;

public class PG_20175 {
    public static void main(String[] args){
        int[][] dice = {{40, 41, 42, 43, 44, 45},{43, 43, 42, 42, 41, 41},{1, 1, 80, 80, 80, 80},{70, 70, 1, 1, 70, 70}};
        int[] result = solution(dice);
        for(int i : result){
            System.out.print(i+" ");
        }
    }
    static int max = 0, win = 0;
    public static int[] solution(int[][] dice) {
        int[] answer = {};
        int n = dice.length;
        int count = n / 2;
        int[] player = new int[count];

        for(int i=0;i<count;i++) player[i] = i+1;
        while (true) {
            boolean[] check = new boolean[n+1];
            int[] otherPlayer = new int[count];

            int order = count - 1;
            while (order >= 0 && player[order] == n - count + order + 1) order--;
            if (order == -1)  break;
            player[order]++;
            for(int j=order+1; j<count;j++) player[j] = player[j-1] + 1;
            for(int i=0;i<count;i++) check[player[i]] = true;

            int point = 0;
            for(int i=1;i<=n;i++){
                if(!check[i]){
                    otherPlayer[point] = i;
                    point++;
                }
            }
            diceCalc(dice, player, otherPlayer, new int[count], new int[count], 0, n);
            System.out.println("win : "+win+", max : " + max);
            for(int i : player) System.out.print(i+" ");
            System.out.println();
            if(win > max){
                answer = player.clone();
                max = win;
            }
            win = 0;
        }
        return answer;
    }
    public static int diceSum(int[][] dices, int deps, int count){

        int sum = 0;

        return sum;
    }
    public static void diceCalc(int[][] dices, int[] player1, int[] player2, int[] player1Arr, int[] player2Arr, int deps, int n){
        if(deps == n){
            int player1Sum = 0, player2Sum = 0;
            for(int i=0;i<n/2;i++){
                player1Sum += player1Arr[i];
                player2Sum += player2Arr[i];
            }
            if(player1Sum > player2Sum) win++;
            return;
        }
        if(deps < n / 2){
            int[] player1Dices = player1Arr.clone();
            int[] dice = dices[player1[deps]-1];
            for(int i=0;i<6;i++){
                if(i > 1 && dice[i] == dice [i-1]) continue;
                player1Dices[deps] = dice[i];
                diceCalc(dices, player1, player2, player1Dices, player2Arr, deps+1, n);
            }
        }
        else{
            int[] player2Dices = player2Arr.clone();
            int[] dice = dices[player2[deps-(n/2)]-1];
            for(int i=0;i<6;i++){
                if(i > 1 && dice[i] == dice [i-1]) continue;
                player2Dices[deps-(n/2)] = dice[i];
                diceCalc(dices, player1, player2, player1Arr, player2Dices, deps+1, n);
            }
        }
    }
}

