import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class p1774 {
	public static class Pos{
		public long x;
		public long y;
		public Pos(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static class Edge implements Comparable<Edge>{
		public int from;
		public int to;
		public double weight;
		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		public int compareTo(Edge e) {
			if(e.weight > weight) return -1;
			else if(e.weight < weight) return 1;
			else return 0;
		}
	}
	public static int N, M, parents[], cnt=1;
	public static Pos[] arr;
	public static ArrayList<Edge> edges = new ArrayList<>();
	public static double ans;
	public static boolean[] visit;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new Pos[N+1];
		parents = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int i=1; i<N; i++) {
			for(int j=i+1; j<=N; j++) {
				edges.add(new Edge(i, j, getDist(i, j)));
			}
		}
		visit = new boolean[N+1];
		Collections.sort(edges);
		make();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			union(from, to);
		}
		
		for(int i=0; i<edges.size(); i++) {
			if(union(edges.get(i).from, edges.get(i).to)) {
				ans += edges.get(i).weight;
			}
			
			if(cnt == N) break;
		}
		
		System.out.println(String.format("%.2f", ans));
		
	}
	
	public static void make() {
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int p) {
		if(parents[p] == p) return p;
		return parents[p] = find(parents[p]);
	}
	
	public static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa == pb) return false;
		
		if(pa > pb) {
			parents[pa] = pb;
		}else {
			parents[pb] = pa;
		}
		cnt++;
		return true;
		
	}
	
	public static double getDist(int i, int j) {
		return Math.sqrt((arr[i].x-arr[j].x)*(arr[i].x-arr[j].x) + (arr[i].y-arr[j].y)*(arr[i].y-arr[j].y));
	}
}
