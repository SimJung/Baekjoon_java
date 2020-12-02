import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p9466 {
	public static int N, ans;
	public static int arr[], order[], fNum[];
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N+1];
			order = new int[N+1];
			fNum = new int[N+1];
			ans = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=1; i<=N; i++) {
				if(order[i] == 0) {
					dfs(i, i, 1);
				}
			}
			
			
			System.out.println(N - ans);
		}
	}
	
	public static void dfs(int now, int start, int cnt) {
		if(order[now] != 0) {
			if(fNum[now] == start) {
				ans += cnt-order[now];
			}
		}else {
			fNum[now] = start;
			order[now] = cnt;
			dfs(arr[now], start, cnt+1);
		}
		
	}
}