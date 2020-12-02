import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p14938 {
	public static final int MAXVAL = 1000000000;
	public static int n, m, r, ans;
	public static int dist[][], items[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		items = new int[n+1];
		dist = new int[n+1][n+1];
		
		Arrays.fill(dist[0], MAXVAL);
		dist[0][0] = 0;
		for(int i=1; i<=n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
			Arrays.fill(dist[i], MAXVAL);
			dist[i][i] = 0;
		}
		
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			if(dist[from][to] > weight) {
				dist[from][to] = weight;
				dist[to][from] = weight;
			}
		}
		
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			int sum = 0;
			for(int j=1; j<=n; j++) {
				if(dist[i][j] <= m) sum += items[j];
			}
			
			if(sum > ans) ans = sum;
		}
		
		System.out.println(ans);
		
	}
}
