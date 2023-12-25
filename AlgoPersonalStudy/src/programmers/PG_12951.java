package programmers;

public class PG_12951 {
    public static void main(String[] args) {
        String str = "  for the what 1what  ";
        String result = solution(str);
        System.out.println(result);
    }
    public static String solution(String s){
        String answer = "";
        String str = s.toLowerCase();
        char[] charArr = str.toCharArray();
        boolean check = true;
        for(int i=0;i<charArr.length;i++){
            char c = charArr[i];
            if(c == ' '){
                check = true;
                continue;
            }
            if(check){
                check = false;
                if(c >= 97 && c<= 122) charArr[i] -= 32;
            }
        }
        answer = new String(charArr);
        return answer;
    }
}
