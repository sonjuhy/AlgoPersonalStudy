import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Toss_2022_03_24_1st {
	static int k,m,answer=0;//여기 다 지우고
	public static void main(String[] args) throws Exception{
		// 여기서부터
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		String tmp = br.readLine();
		String[] inttmp = br.readLine().split(", ");
		
		int[] amounts = new int[inttmp.length];
		for (int i = 0; i < amounts.length; i++) {
			amounts[i] = Integer.parseInt(inttmp[i]);
		}
		tmp = tmp.substring(1,tmp.length()-1);
		
		String[] names = tmp.split(", ");
		//여기 위는 다 지우셈
		int count = 1;
		String customer = " ";
		for (int i = 0; i < names.length; i++) {
			boolean check = false;
			if(amounts[i] >= m) {
				check = true;
			}
			if(customer.equals(names[i].toUpperCase())) {
				count++;
				if(count >= k) {
					check = true;
				}
			}
			else {
				customer = names[i].toUpperCase();
				count = 1;
			}
			if(check) answer++;
		}
		
		System.out.println(answer); // 이거도 지워
		//return answer;
	}

}
