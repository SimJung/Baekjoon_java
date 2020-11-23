import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1504 {
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
	public static int N, E, dist[], v1, v2, ans = Integer.MAX_VALUE;
	public static ArrayList<Edge> list[];
	public static PriorityQueue<Edge> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		dist = new int[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from].add(new Edge(to, weight));
			list[to].add(new Edge(from, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		int d1 = dijkstra(1, v1, 0);
		int d2 = Integer.MAX_VALUE;
		int d3 = Integer.MAX_VALUE;
		if(d1 != Integer.MAX_VALUE) {
			d2 = dijkstra(v1, v2, d1);
			if(d2 != Integer.MAX_VALUE) {
				d3 = dijkstra(v2, N, d2);
			}
		}
		
		ans = (ans > d3 ? d3 : ans);
		
		d1 = dijkstra(1, v2, 0);
		if(d1 != Integer.MAX_VALUE) {
			d2 = dijkstra(v2, v1, d1);
			if(d2 != Integer.MAX_VALUE) {
				d3 = dijkstra(v1, N, d2);
			}
		}
		
		ans = (ans > d3 ? d3 : ans);
		
		if(ans == Integer.MAX_VALUE) System.out.println("-1");
		else System.out.println(ans);
	}
	
	
	public static int dijkstra(int start, int end, int startDist) {
		pq.clear();
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = startDist;
		for(int i=0; i<list[start].size(); i++) {
			if(dist[list[start].get(i).to] > dist[start] + list[start].get(i).weight) {
				dist[list[start].get(i).to] = dist[start] + list[start].get(i).weight;
				pq.offer(new Edge(list[start].get(i).to, dist[list[start].get(i).to]));
			}
		}
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			if(now.weight > dist[now.to]) continue;
			
			for(int i=0; i<list[now.to].size(); i++) {
				if(dist[list[now.to].get(i).to] > dist[now.to] + list[now.to].get(i).weight) {
					dist[list[now.to].get(i).to] = dist[now.to] + list[now.to].get(i).weight;
					pq.offer(new Edge(list[now.to].get(i).to, dist[list[now.to].get(i).to]));
				}
			}
		}
		
		return dist[end];
	}
}
