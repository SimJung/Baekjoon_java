import java.util.Scanner;

public class p17069 {
	static int N;
	static long dp[][][];
	static boolean arr[][];
	static int[][] delta = { { 0, 1 }, { 1, 1 }, { 1, 0 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = (sc.nextInt() == 1 ? true : false);
			}
		}
		dp = new long[N][N][3];
		dp[0][1][0] = 1;
		
		for(int i=0; i<N; i++) {
			for(int j=1; j<N; j++) {
				int ni = i+1;
				int nj = j+1;
				if(nj < N && !arr[i][nj]) {
					dp[i][nj][0] = dp[i][j][0] + dp[i][j][1];
				}
				
				if(ni < N && !arr[ni][j]) {
					dp[ni][j][2] = dp[i][j][1] + dp[i][j][2];
				}
				
				if(ni < N && nj < N && !arr[ni][nj] && !arr[ni][j] && !arr[i][nj]) {
					dp[ni][nj][1] = dp[i][j][0] + dp[i][j][1] + dp[i][j][2];
				}
			}
		}
		System.out.println(dp[N-1][N-1][0]+dp[N-1][N-1][1]+dp[N-1][N-1][2]);
	}
}
