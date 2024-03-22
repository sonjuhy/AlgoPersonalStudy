package programmers;

import java.util.Arrays;
import java.util.HashMap;

public class PG_131127 {
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
//        String[] want = {"bananaa"};
//        int[] number = {3};
        String[] discount = {"apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana", "chicken", "apple"};
//        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        int answer = solution(want, number, discount);
        System.out.println(answer);
    }

    public static int solution(String[] want, int[] number, String[] discount){
        int answer = 0;
        HashMap<String, Integer> product = new HashMap<>();
        for(int i=0;i<want.length;i++){
            product.put(want[i], i);
        }

        for(int i=0;i<10;i++){
            if(product.containsKey(discount[i])){
                number[product.get(discount[i])]--;
            }
        }
        if(sum(number)) answer += 1;

        int windowCount = discount.length - 10;
        for(int w=0;w<windowCount;w++){
            if(product.containsKey(discount[w])){
                number[product.get(discount[w])]++;
            }
            if(product.containsKey(discount[w+10])){
                number[product.get(discount[w+10])]--;
            }
            System.out.println(Arrays.toString(number));
            if(sum(number)) answer++;
        }

        return answer;
    }
    public static boolean sum(int[] num){
        for(int n : num){
            if(n > 0) return false;
        }
        return true;
    }
}
