import java.util.Arrays;
import java.util.Scanner;

public class p17626 {
	public static int dp[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		dp = new int[n+1];
		Arrays.fill(dp, 5);
		System.out.println(getDp(n));
	}
	
	public static int getDp(int n) {
		if(n == 0) return 0;
		if(dp[n] != 5) return dp[n];
		else {
			for(int i = (int)Math.sqrt(n); i>=1; i--) {
				int nowVal= 1 + getDp(n - i*i);
				if(dp[n] > nowVal) dp[n] = nowVal;
			}
			return dp[n];
		}
	}
}
