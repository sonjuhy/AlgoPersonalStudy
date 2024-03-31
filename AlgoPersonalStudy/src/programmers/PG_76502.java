package programmers;

public class PG_76502 {
    public static void main(String[] args) {
        String s = "{(})";
        int answer = solution(s);
        System.out.println(answer);
    }

    public static int solution(String s){
        int answer = 0;
        int len = s.length();
        String tmpStr = s;
        if(check(tmpStr)) answer++;

        for(int i=0;i<len-1;i++){
            tmpStr = tmpStr.substring(1, len) + tmpStr.charAt(0);
            if(check(tmpStr)) answer++;
        }
        return answer;
    }
    public static boolean check(String s){
        int[] checked = new int[6];
        System.out.println();
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            char c = chars[i];
            System.out.println(i+", "+c+", "+checked[1]);
            switch (c){
                case '[':
                    checked[0]++;
                    break;
                case '{':
                    checked[1]++;
                    break;
                case '(':
                    checked[2]++;
                    break;
                case ')':
                    if(checked[2] < 1 || chars[i-1] == '(') return false;
                    checked[2]--;
                    break;
                case '}':
                    if(checked[1] < 1 || chars[i-1] == '{') return false;
                    checked[1]--;
                    break;
                case ']':
                    if(checked[0] < 1 || chars[i-1] == '[') return false;
                    checked[0]--;
                    break;
            }
        }
        for(int num : checked){
            if(num != 0) return false;
        }
        return true;
    }
}
