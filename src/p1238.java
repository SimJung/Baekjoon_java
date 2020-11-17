import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1238 {
	public static class Edge implements Comparable<Edge>{
		public int to;
		public int weight;
		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		
		public int compareTo(Edge e) {
			return weight - e.weight;
		}
	}
	public static int N, M, X, ans;
	public static int dist[];
	
	public static ArrayList<Edge> edges[];
	public static PriorityQueue<Edge> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		dist = new int[N+1];
		edges = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			edges[i] = new ArrayList<Edge>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edges[from].add(new Edge(to, weight));
		}
		
		for(int i=1; i<=N; i++) {
			if(i == X) continue;
			int temp = dijkstra(i, X);
			//System.out.println(temp);
			ans = (ans < temp ? temp : ans);
		}
		
		System.out.println(ans);
	}
	
	public static int dijkstra(int from, int to) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		pq.clear();
		dist[from] = 0;
		for(int i=0; i<edges[from].size(); i++) {
			pq.offer(edges[from].get(i));
			dist[edges[from].get(i).to] = edges[from].get(i).weight;
		}
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if(now.weight > dist[now.to]) continue;
			
			for(int i=0; i<edges[now.to].size(); i++) {
				if(dist[edges[now.to].get(i).to] > dist[now.to] + edges[now.to].get(i).weight) {
					dist[edges[now.to].get(i).to] = dist[now.to] + edges[now.to].get(i).weight;
					pq.offer(new Edge(edges[now.to].get(i).to, dist[edges[now.to].get(i).to]));
				}
			}
		}
		
		int fisrtVal = dist[to];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		pq.clear();
		dist[to] = fisrtVal;
		for(int i=0; i<edges[to].size(); i++) {
			pq.offer(new Edge(edges[to].get(i).to, dist[to]+edges[to].get(i).weight));
			dist[edges[to].get(i).to] = dist[to] + edges[to].get(i).weight;
		}
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if(now.weight > dist[now.to]) continue;
			
			for(int i=0; i<edges[now.to].size(); i++) {
				if(dist[edges[now.to].get(i).to] > dist[now.to] + edges[now.to].get(i).weight) {
					dist[edges[now.to].get(i).to] = dist[now.to] + edges[now.to].get(i).weight;
					pq.offer(new Edge(edges[now.to].get(i).to, dist[edges[now.to].get(i).to]));
				}
			}
		}
		
		return dist[from];
	}

}
