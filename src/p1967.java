import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1967 {
	public static class Edge{
		public int to;
		public int weight;
		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
	}
	public static ArrayList<Edge> edgeList[];
	public static boolean visit[];
	public static int maxDist, maxIdx, N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		edgeList = new ArrayList[N+1];
		visit = new boolean[N+1];
		for(int i=1; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			if(edgeList[from] == null) {
				edgeList[from] = new ArrayList<>();
			}
			edgeList[from].add(new Edge(to, weight));
			
			if(edgeList[to] == null) {
				edgeList[to] = new ArrayList<>();
			}
			edgeList[to].add(new Edge(from, weight));
		}
		
		dfs(1, 0);
		maxDist = 0;
		Arrays.fill(visit, false);
		dfs(maxIdx, 0);
		
		System.out.println(maxDist);
	}
	
	public static void dfs(int start, int dist) {
		visit[start] = true;
		if(maxDist < dist) {
			maxDist = dist;
			maxIdx = start;
		}
		
		if(edgeList[start] != null) {
			for(int i=0; i<edgeList[start].size(); i++) {
				if(!visit[edgeList[start].get(i).to]) {
					dfs(edgeList[start].get(i).to, dist + edgeList[start].get(i).weight);
				}
			}
		}
	}

}
