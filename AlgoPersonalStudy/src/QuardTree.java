import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuardTree {
	static int max_x = 1024;
	static int max_y = 1024;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String s1 = st.nextToken();
		String s2 = st.nextToken();

	}
	static void calc(int dp, int div, int x, int y, int x_s, int y_s, String pixel) {
		char[] tmp = pixel.toCharArray();
		for (int i = 0; i < pixel.length(); i++) {
			switch(div) {
			case 0:
				x_s = x_s/2;
				y_s = y_s/2;
				break;
			case 1:
				x = x/2;
				y_s = y_s/2;
				break;
			case 2:
				x = x/2;
				y = y/2;
				break;
			case 3:
				x_s = x_s/2;
				y = y/2;
				break;
			}
			if(tmp[0] == 'p') {
				calc(dp+1, div, x, y, x_s, y_s,pixel.substring(1, pixel.length()));
			}
			div = (div++)%4;
			
			printPixel(x, y, x_s, y_s); 
		}
		
		
	}
	
	static void printPixel(int x, int y, int x_s, int y_s) {
		for(int my = y; my > y_s; my--) {
			for (int mx = x; mx > x_s; mx--) {
				// print
			}
		}

	}
}
