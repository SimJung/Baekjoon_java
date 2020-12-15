import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p9465 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int maxVal = 0;
			int n = Integer.parseInt(br.readLine());
			
			int arr[][] = new int[2][n];
			int dp[][] = new int[3][n];
			
			for(int i=0; i<2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			dp[2][0] = 0;
			
			maxVal = (dp[0][0] > dp[1][0] ? dp[0][0] : dp[1][0]);
			
			for(int i=1; i<n; i++) {
				dp[0][i] = Math.max(dp[1][i-1] + arr[0][i], dp[2][i-1] + arr[0][i]);
				
				dp[1][i] = Math.max(dp[0][i-1] + arr[1][i], dp[2][i-1] + arr[1][i]);
				
				dp[2][i] = Math.max(Math.max(dp[0][i-1], dp[1][i-1]), dp[2][i-1]);
				
				if(maxVal < dp[0][i]) maxVal = dp[0][i];
				if(maxVal < dp[1][i]) maxVal = dp[1][i];
				if(maxVal < dp[2][i]) maxVal = dp[2][i];
			}
			
			System.out.println(maxVal);
		}
	}

}
