import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1774 {
	public static class Pos{
		public int x;
		public int y;
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static class Info implements Comparable<Info>{
		public int idx;
		public double weight;
		public Info(int idx, double weight) {
			super();
			this.idx = idx;
			this.weight = weight;
		}
		
		public int compareTo(Info i) {
			if(i.weight > weight) return 1;
			else if(i.weight < weight) return -1;
			else return 0;
		}
	}
	public static int N, M;
	public static Pos arr[];
	public static PriorityQueue<Info> edges[];
	public static PriorityQueue<Info> pq = new PriorityQueue<>();
	public static boolean[] visit;
	public static double ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		edges = new PriorityQueue[N+1];
		arr = new Pos[N+1];
		visit = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			edges[i] = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			arr[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int i=1; i<N; i++) {
			for(int j=i+1; j<=N; j++) {
				edges[i].offer(new Info(j, getDist(i, j)));
				edges[j].offer(new Info(i, getDist(i, j)));
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
		}
	}
	
	public static double getDist(int i, int j) {
		return Math.sqrt((arr[i].x-arr[j].x)*(arr[i].x-arr[j].x) + (arr[i].y-arr[j].y)*(arr[i].y-arr[j].y));
	}
}
