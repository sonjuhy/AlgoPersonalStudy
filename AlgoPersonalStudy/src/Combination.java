
public class Combination {
	static int[] list = {1,2,3,4,5}, save_list;
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = 3;
		save_list = new int[N];
		
		combination(0, 0);
	}
	static void combination(int start, int dp) {
		if(dp == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(save_list[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < list.length; i++) {
			save_list[dp] = list[i];
			combination(i+1, dp+1);
		}
	}
}
