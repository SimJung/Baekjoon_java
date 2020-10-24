import java.util.Arrays;
import java.util.Scanner;

public class p2293 {
	static int n, k;
	public static int coins[];
	public static int dp[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		coins = new int[n];
		dp = new int[k+1];
		for(int i=0; i<n ; i++) {
			coins[i] = sc.nextInt();
		}
		
		for(int i=0; i<n; i++) {
			if(coins[i] <= k)
				dp[coins[i]]++;
			for(int j=coins[i]; j<=k; j++) {
				if(j-coins[i] >= 0) {
					dp[j]+=dp[j-coins[i]];
				}
			}
			
		}
		System.out.println(dp[k]);
		
	}
	
	public static int getDP(int k) {
		if(dp[k] != 0) return dp[k];
		for(int i=0; i<n; i++) {
			if(k - coins[i] > 0) {
				dp[k] += getDP(k - coins[i]);
			}
		}
		return dp[k];
	}
}
