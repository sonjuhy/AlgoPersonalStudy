package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SF_6293 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        int max = 0, maxPoint = 0;
        for(int n=0;n<N;n++){
            arr[n] = Integer.parseInt(st.nextToken());
            if(max <= arr[n]){
                maxPoint = n;
                max = arr[n];
            }
        }
        int maxClaimCount = 0;
        for(int n=0;n<=maxPoint;n++){
            int claimCount = 1, nowHeight = arr[n];
            for(int m=n+1;m<=maxPoint;m++){
                if(nowHeight < arr[m]){
                    claimCount++;
                }
            }
            maxClaimCount = Math.max(maxClaimCount, claimCount);
        }
        for(int n=maxPoint+1;n<N;n++){
            int claimCount = 1, nowHeight = arr[n];
            for(int m=n+1;m<N;m++){
                if(nowHeight < arr[m]){
                    claimCount++;
                }
            }
            maxClaimCount = Math.max(maxClaimCount, claimCount);
        }
        System.out.println(maxClaimCount);
    }
}
