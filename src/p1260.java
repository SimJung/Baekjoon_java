import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
public class p1260 {
	static boolean arr[][];
	static boolean visit[];
	static int N, M, V;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		arr = new boolean[N+1][N+1];
		
		int from, to;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(bf.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			
			arr[from][to] = true;
			arr[to][from] = true;
		}
		
		visit = new boolean[N+1];
		visit[V] = true;
		dfs(V);
		bw.write("\n");
		bw.flush();
		
		visit = new boolean[N+1];
		visit[V] = true;
		bfs(V);
		bw.write("\n");
		bw.flush();
		
		bw.close();
	}
	
	public static void dfs(int n) throws IOException{
		bw.write(n+" ");
		for(int i=1; i<=N; i++) {
			if(arr[n][i] && !visit[i])
			{
				visit[i] = true;
				dfs(i);
			}
		}
	}
	
	public static void bfs(int n) throws IOException{
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		bw.write(n+" ");
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int i=1; i<=N; i++) {
				if(arr[temp][i] && !visit[i]) {
					visit[i] = true;
					bw.write(i+" ");
					q.offer(i);
				}
			}
		}
	}

}
