
public class Subset {
	//subset 1
	static int[] list = {1,2,3,4,5}, save_list;
	static int count = 0;
	
	//subset 2
	static int[] list2 = {1,2,3,4,5}, save_list2;
	static int count2 = 0;
	static boolean[] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//N = 3;
		//subset1(0);
		//System.out.println(count);
		
		save_list2 = new int[list2.length];
		visited = new boolean[list2.length];
		
		subset2(0);
	}
	static void subset1(int dp) {
		if(dp > list.length) {
			return;
		}
		save_list = new int[dp];
		combination(0, 0, dp);
		subset1(dp+1);
	}
	static void combination(int start, int dp, int N) {
		if(dp == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(save_list[i]+" ");
			}
			System.out.println();
			count++;
			return;
		}
		for (int i = start; i < list.length; i++) {
			save_list[dp] = list[i];
			combination(i+1, dp+1, N);
		}
	}
	static void subset2(int dp) {
		if(dp == list2.length) {
			//print
			for (int i = 0; i < list2.length; i++) {
				if(!visited[i]) System.out.print(list2[i] + " ");
			}
			System.out.println();
			return;
		}
		visited[dp] = true;
		subset2(dp+1);
		visited[dp] = false;
		subset2(dp+1);
	}
}
