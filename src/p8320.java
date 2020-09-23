import java.util.Scanner;

public class p8320 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 0;
		for(int i=1; i<=N; i++) {
			int num = 0;
			for(int j=1; j<=i ;j++) {
				if(i % j == 0) num++;
			}
			if(num % 2 == 1) num++;
			ans += num/2;
		}
		System.out.println(ans);
	}

}
