
import java.util.Scanner;
public class p11050 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt();
		long ans = 1;
		for(int i=0; i<k; i++) {
			ans *= (n-i);
		}
		
		for(int i=0; i<k; i++) {
			ans /= (k-i);
		}
		
		System.out.println(ans);
	}

}
