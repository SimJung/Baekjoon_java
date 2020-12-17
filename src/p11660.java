import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11660 {
	public static int N, M;
	public static int arr[][], dp[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];
		dp = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				dp[i][j] = dp[i-1][j] + dp[i][j-1] + arr[i][j] - dp[i-1][j-1];
				
				//System.out.print(dp[i][j] + " ");
			}
			//System.out.println();
			
		}
		
		for(int i=0; i<M; i++) {
			int x1, x2, y1, y2;
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			System.out.println(dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1]);
		}
	}

}
