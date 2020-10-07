import java.util.Arrays;
import java.util.Scanner;

public class p2294 {
	public static int N, K;
	public static int coins[];
	public static int dp[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		coins = new int[N];
		dp = new int[100001];
		Arrays.fill(dp, 1000000000);
		for(int i=0; i<N; i++) {
			coins[i] = sc.nextInt();
			dp[coins[i]] = 1;
		}
		
		for(int i=1; i<=K; i++) {
			for(int j=0; j<N; j++) {
				if(i - coins[j] > 0 && dp[i] > dp[i-coins[j]]+1) {
					dp[i] = dp[i-coins[j]]+1;
				}
			}
		}
		
		System.out.println((dp[K] == 1000000000 ? -1 : dp[K]));
	}

}
