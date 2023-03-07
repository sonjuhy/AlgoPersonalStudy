package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class SF_654 {

	static char[] arr;
	static int answer = 0, N = 0;
	static Deque<Character> lastArr = new ArrayDeque<>();
	static Stack<Character> parking = new Stack<>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] busStr = br.readLine().split(" ");
        int[] bus = new int[n];
        for(int i=0; i<n; i++) {
            bus[i] = Integer.parseInt(busStr[i]);
        }
        int[][] arr = new int[n+1][n+1];

        for(int j=n-1; j>=0; j--) {
            for(int x=1; x<=n; x++) {
                if(bus[j] < x) {
                    arr[x][j] = arr[x][j+1] + 1;
                } else {
                    arr[x][j] = arr[x][j+1];
                }
            }
        }
        int ans = 0;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(bus[i] < bus[j]) {
                    ans += arr[bus[i]][j];
                }
            }
        }
        System.out.println(ans);
	}
}
