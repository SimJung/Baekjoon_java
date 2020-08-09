package boj_java;
import java.util.Scanner;
public class p9372 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans, n, m, T;
		T = sc.nextInt();
		while(T-- > 0) {
			n = sc.nextInt();
			m = sc.nextInt();
			ans = n-1;
			
			for(int i=0; i<m*2; i++) {
				n = sc.nextInt();
			}
			
			System.out.println(ans);
		}
	}

}
