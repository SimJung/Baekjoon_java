import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p11779 {
	public static class Edge implements Comparable<Edge>{
		public int to;
		public int weight;
		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		
		public int compareTo(Edge e) {
			return weight -e.weight;
		}
	}
	public static int n, m, start, end, dist[], cnt;
	public static ArrayList<Edge> edgeList[];
	public static boolean visit[], found;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		edgeList = new ArrayList[n+1];
		dist = new int[n+1];
		visit = new boolean[n+1];
		for(int i=1; i<=n; i++){
			edgeList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edgeList[from].add(new Edge(to, weight));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		
	}
	
	public static void dijkstra(int start, int end, int idx) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for(int i=0; i<edgeList[start].size(); i++) {
			if(!visit[edgeList[start].get(i).to] && dist[edgeList[start].get(i).to] > dist[start] + edgeList[start].get(i).weight) {
				visit[edgeList[start].get(i).to] = true;
				dist[edgeList[start].get(i).to] = dist[start] + edgeList[start].get(i).weight;
				pq.offer(new Edge(edgeList[start].get(i).to, dist[edgeList[start].get(i).to]));
			}
		}
		
		while(!pq.isEmpty() && !found) {
			Edge now = pq.poll();
			
			if(now.weight > dist[now.to]) continue;
			
			if(now.to == end)
		}
	}
}
