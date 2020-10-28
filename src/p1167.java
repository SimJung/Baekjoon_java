import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1167 {
	public static class Edge{
		public int to;
		public int weight;
		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
	}
	
	public static ArrayList<Edge> edges[];
	public static int V;
	public static boolean[] visit;
	public static int ans = 0, ansIdx, v1, v2;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		V = Integer.parseInt(br.readLine());
		edges = new ArrayList[V+1];
		visit = new boolean[V+1];
		
		for(int i=1; i<=V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			edges[from] = new ArrayList<>();
			while(true) {
				int to = Integer.parseInt(st.nextToken());
				if(to == -1) break;
				int weight = Integer.parseInt(st.nextToken());
				edges[from].add(new Edge(to, weight));
			}
		}
		
		dfs(1, 0);
		v1 = ansIdx;
		
		ans = 0;
		Arrays.fill(visit, false);
		
		dfs(v1, 0);
		v2 = ansIdx;
		
		ans = 0;
		Arrays.fill(visit, false);
		getDist(v1, 0, v2);
		System.out.println(ans);
	}
	
	public static void dfs(int n, int now) {
		visit[n] = true;
		if(ans < now) {
			ansIdx = n;
			ans = now;
		}
		for(int i=0; i<edges[n].size(); i++) {
			if(!visit[edges[n].get(i).to]) {
				dfs(edges[n].get(i).to, edges[n].get(i).weight + now);
			}
		}
	}
	
	public static void getDist(int n, int now, int to) {
		visit[n] = true;
		if(n == to) {
			ansIdx = n;
			ans = now;
			return ;
		}
		for(int i=0; i<edges[n].size(); i++) {
			if(!visit[edges[n].get(i).to]) {
				getDist(edges[n].get(i).to, edges[n].get(i).weight + now, to);
			}
		}
	}
}
