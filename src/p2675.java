
import java.util.Scanner;
public class p2675 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			int n;
			String s;
			n = sc.nextInt();
			s = sc.next();
			for(int i=0; i<s.length(); i++) {
				for(int j=0; j<n; j++) {
					System.out.print(s.charAt(i));
				}
			}
			System.out.println();
		}
	}

}
