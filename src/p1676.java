import java.util.Scanner;

public class p1676 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 0;
		for(int i=5; i<=N; i+=5) {
			int temp = i;
			while(temp % 5 == 0) {
				ans++;
				temp/=5;
			}
		}
		System.out.println(ans);
	}

}
