package boj_java;
import java.util.Scanner;
public class p9012 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0) {
			int s = 0;
			String str = sc.next();
			boolean isVps = true;
			for(int i=0; i<str.length(); i++) {
				if(s>=0 && str.charAt(i) == '(')
					s++;
				else if(s > 0 && str.charAt(i) == ')')
					s--;
				else
				{
					isVps = false;
					break;
				}
			}
			
			if(s != 0) isVps = false;
			System.out.println((isVps ? "YES" : "NO"));
		}
	}

}
