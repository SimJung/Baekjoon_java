import java.util.Scanner;

public class p12865 {
	public static int N, K, W, V, ans;
	public static int dp[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
			
		dp = new int[N+1][K+1];
		for(int i=1; i<=N; i++) {
			W = sc.nextInt();
			V = sc.nextInt();
			
			for(int j=1; j<=K; j++) {
				if(j >= W && (dp[i-1][j-W] + V > dp[i-1][j])) {
					dp[i][j] = dp[i-1][j-W] + V;
				}else {
					dp[i][j] = dp[i-1][j];
				}
				if(ans < dp[i][j]) ans = dp[i][j];
			}
		}
		
		System.out.println(ans);
	}

}
