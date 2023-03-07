public class Permutation {
	static int[] list = {1,2,3,4,5}, save_list;
	static boolean[] visited;
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = 3;
		save_list = new int[N];
		visited = new boolean[list.length];
		permutation(0);
	}
	static void permutation(int dp) {
		if(dp == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(save_list[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < list.length; i++) {
			if(visited[i]) continue;
			save_list[dp] = list[i];
			visited[i] = true;
			permutation(dp+1);
			visited[i] = false;
		}
	}
}