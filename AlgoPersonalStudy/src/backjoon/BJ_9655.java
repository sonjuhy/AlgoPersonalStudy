package backjoon;

import java.io.*;
import java.util.*;

public class BJ_9655 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if((N & 1) == 1) System.out.println("SK");
		else System.out.println("CY");
	}

}
