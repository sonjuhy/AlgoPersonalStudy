import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Toss_2022_03_24_2nd {
//	static int count = 0;
//	static int[] answer = {1,0};
//	static int[] before_times = new int[6]; //YYYY : MM : DD : hh : mm : ss
//	static int[] now_times = new int[6]; //YYYY : MM : DD : hh : mm : ss
//	static int[] add_times = new int[4]; // DD : hh : mm : ss
//	
//	static String[] times = {"01:06:30:00","01:01:12:00","00:00:09:25"};
//	public static void main(String[] args) throws Exception{
//		//여기서부터
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String[] tmps = br.readLine().split(":"); // 여기까지 지우고
//		//String[] tmps = s.split(":");  이거 주석 풀고
//		// main에 있는 int answer 지우고 전역변수 쟤로 대신 써라
//		for (int i = 0; i < tmps.length; i++) {
//			before_times[i] = Integer.parseInt(tmps[i]);
//			now_times[i] = before_times[i];
//		}
//		count = before_times[2];
//		tmps = times;
//		for (int i = 0; i < tmps.length; i++) {
//			String[] tmps_tmp = tmps[i].split(":");
//			for (int j = 0; j < tmps_tmp.length; j++) {
//				add_times[j] = Integer.parseInt(tmps_tmp[j]);
//			}
//			calcAddTime(0);
//			copyTimes();
//		}
//		
//		
//		answer[1] = now_times[2] - count + 1;
//		System.out.println(answer[0]+" : " + answer[1]);
//		//return answer;
//	}
//	static void calcAddTime(int dp) {
//		if(dp == 5) {			
//			boolean result = calcTimeDiff();
//			if(!result) {
//				answer[0] = 0;
//			}
//			return;
//		}
//		switch(dp) {
//		case 0: // ss
//			int second = now_times[5] + add_times[3];
//			if(second >= 60) {
//				now_times[5] = second - 60;
//				now_times[4]++;
//			}
//			else {
//				now_times[5] = second;
//			}
//			calcAddTime(dp+1);
//			break;
//		case 1: // mm
//			int minute = now_times[4] + add_times[2];
//			if(minute >= 60) {
//				now_times[4] = minute - 60;
//				now_times[3]++;
//			}
//			else {
//				now_times[4] = minute;
//			}
//			calcAddTime(dp+1);
//			break;
//		case 2: // hh
//			int hour = now_times[3] + add_times[1];
//			if(hour >= 24) {
//				now_times[3] = hour - 24;
//				now_times[2]++;
//			}
//			else {
//				now_times[3] = hour;
//			}
//			calcAddTime(dp+1);
//			break;
//		case 3: // DD
//			int day = add_times[0] + now_times[2];
//			if(day >= 30) {
//				now_times[2] = day - 30;
//				now_times[1]++;
//			}
//			else {
//				now_times[2] = day;
//			}
//			calcAddTime(dp+1);
//			break;
//		case 4: // MM
//			if(now_times[1] >= 12) {
//				now_times[1] -= 12;
//				now_times[0]++;
//			}
//			calcAddTime(dp+1);
//			break;
//		}
//	}
//	static boolean calcTimeDiff() {
//		// 03 29 -> 03 30
//		if(now_times[2] - before_times[2] > 1 || now_times[2] - before_times[2] < 0) { 
//			if(!((now_times[1] - before_times[1] == 1) && (before_times[2] - now_times[2] == 29))) {
//				//2021 12 30 -> 2022 01 01
//				int diff_month = now_times[1] - before_times[1]; // 11 diff
//				int diff_day = before_times[2] -now_times[2]; // 29 diff
//				int diff_year = now_times[0] - before_times[0]; // 1 diff
//				if(!(diff_month == 11 && diff_day == 29 && diff_year == 1)) {
//					return false;
//				}
//				
//			}
//		}
//		return true;
//	}
//	static void copyTimes() {
//		for (int i = 0; i < before_times.length; i++) {
//			before_times[i] = now_times[i];
//		}
//	}
//}

public class Toss_2022_03_24_2nd {
    static int count = 0;
    static int[] answer = {1,0};
    static int[] before_times = new int[6]; //YYYY : MM : DD : hh : mm : ss
    static int[] now_times = new int[6]; //YYYY : MM : DD : hh : mm : ss
    static int[] add_times = new int[4]; // DD : hh : mm : ss

    public static void main(String[] args) {
        Toss_2022_03_24_2nd solution = new Toss_2022_03_24_2nd();
        int[] solution1 = solution.solution("2021:04:12:16:08:35", new String[]{"01:06:30:00", "01:04:12:00"});
        System.out.println(solution1[0]+":"+solution1[1]);
    }

    public int[] solution(String s, String[] times) {
    	String[] tmps = s.split(":");
        for (int i = 0; i < tmps.length; i++) {
            before_times[i] = Integer.parseInt(tmps[i]);
            now_times[i] = before_times[i];
        }
        count = before_times[2];
        for (int i = 0; i < times.length; i++) {
            String[] tmps_tmp = times[i].split(":");
            for (int j = 0; j < tmps_tmp.length; j++) {
                add_times[j] = Integer.parseInt(tmps_tmp[j]);
            }
            calcAddTime(0);
            copyTimes();
        }

        answer[1] = now_times[2] - count + 1;
        return answer;
    }

    static void calcAddTime(int dp) {
        if(dp == 5) {
            int result = calcTimeDiff();
            if(result != 1) {
                answer[0] = 0;
            }
            return;
        }
        switch(dp) {
            case 0: // ss
                int second = now_times[5] + add_times[3];
                if(second >= 60) {
                    now_times[5] = second - 60;
                    now_times[4]++;
                }
                else {
                    now_times[5] = second;
                }
                calcAddTime(dp+1);
                break;
            case 1: // mm
                int minute = now_times[4] + add_times[2];
                if(minute >= 60) {
                    now_times[4] = minute - 60;
                    now_times[3]++;
                }
                else {
                    now_times[4] = minute;
                }
                calcAddTime(dp+1);
                break;
            case 2: // hh
                int hour = now_times[3] + add_times[1];
                if(hour >= 24) {
                    now_times[3] = hour - 24;
                    now_times[2]++;
                }
                else {
                    now_times[3] = hour;
                }
                calcAddTime(dp+1);
                break;
            case 3: // DD
                int day = add_times[0] + now_times[2];
                if(day >= 30) {
                    now_times[2] = day - 30;
                    now_times[1]++;
                }
                else {
                    now_times[2] = day;
                }
                calcAddTime(dp+1);
                break;
            case 4: // MM
                if(now_times[1] >= 12) {
                    now_times[1] -= 12;
                    now_times[0]++;
                }
                calcAddTime(dp+1);
                break;
        }
    }
    static int calcTimeDiff() {
    	String before = "", after = "";
    	for (int i = 0; i < before_times.length-3; i++) {
			before += before_times[i]+":";
			after += now_times[i]+":";
		}
    	before = before.substring(0,before.length()-1);
    	after = after.substring(0,after.length()-1);
    	LocalDate past = LocalDate.parse(before, DateTimeFormatter.ofPattern("yyyy:MM:dd"));
    	LocalDate now = LocalDate.parse(after, DateTimeFormatter.ofPattern("yyyy:MM:dd"));
    	long days = ChronoUnit.DAYS.between(past, now);
        return (int) days;
    }
    static void copyTimes() {
        for (int i = 0; i < before_times.length; i++) {
            before_times[i] = now_times[i];
        }
    }
}
