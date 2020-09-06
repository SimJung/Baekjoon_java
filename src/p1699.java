import java.util.Scanner;

public class p1699 {
	static int N;
	static int dp[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new int[N+1];
		for(int i=1; i<=Math.sqrt(N); i++) {
			dp[i*i] = 1;
		}
		
		System.out.println(dp[N]);
	}

}
