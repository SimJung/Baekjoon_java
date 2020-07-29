package boj_java;
import java.util.Scanner;
public class p8958 {
	public static void main(String[] args) {
		int T;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			String s;
			s = sc.next();
			int ans=0, val = 1;
			
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i) == 'O')
					ans += val++;
				else
					val = 1;
			}
			
			System.out.println(ans);
		}
	}
}
