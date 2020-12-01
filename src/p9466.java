import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p9466 {
	public static int N, ans;
	public static int arr[];
	
	public static boolean visit[], found;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N+1];
			visit = new boolean[N+1];
			ans = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if(arr[i] == i) {
					visit[i] = true;
					ans++;
				}
			}
			
			for(int i=1; i<=N; i++) {
				found = false;
				if(!visit[i]) {
					dfs(i, i);
				}
			}
			
			
			System.out.println(N - ans);
		}
	}
	
	public static void dfs(int start, int end) {
		ans++;
		visit[start] = true;
		if(visit[arr[start]]) {
			if(arr[start] == end) {
				found = true;
				return ;
			}
			
			ans--;
			visit[start] = false;
			return ;
		}else {
			dfs(arr[start], end);
			
			if(!found) {
				ans--;
				visit[start] = false;
			}
		}
		
	}
}