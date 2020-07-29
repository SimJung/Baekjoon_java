package boj_java;
import java.util.Scanner;
public class p11720 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s;
		int n, ans = 0;
		n = sc.nextInt();
		s = sc.next();
		for(int i=0; i<s.length(); i++) {
			ans += s.charAt(i) - '0';
		}
		System.out.println(ans);
	
	}

}
