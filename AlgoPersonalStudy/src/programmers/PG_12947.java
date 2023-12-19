package programmers;

public class PG_12947 {
    public static void main(String[] args) {
        int n = 0;
        boolean result = solution(n);
        System.out.println(result);
    }
    public static boolean solution(int x){
        boolean answer = true;
        String xStr = String.valueOf(x);
        char[] charArr = xStr.toCharArray();
        int num = 0;
        for(char c : charArr){
            num += c - '0';
        }
        if(x % num != 0) answer = false;
        return answer;
    }
}
