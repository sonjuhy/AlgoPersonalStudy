package backjoon.silver;

import java.io.*;
import java.util.*;

public class BJ_25206 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double totalGrade = 0, totalCredit = 0;

        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            double grade = changeToGrade(st.nextToken());
            if(grade >= 0){
                totalGrade += grade * credit;
                totalCredit += credit;
            }
        }
        System.out.println(totalGrade / totalCredit);
    }
    static double changeToGrade(String grade){
        switch (grade){
            case "A+":
                return 4.5;
            case "A0":
                return 4.0;
            case "B+":
                return 3.5;
            case "B0":
                return 3.0;
            case "C+":
                return 2.5;
            case "C0":
                return 2.0;
            case "D+":
                return 1.5;
            case "D0":
                return 1.0;
            case "F":
                return 0;
            case "P":
                return -1;
        }
        return -1;
    }
}
