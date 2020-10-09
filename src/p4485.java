import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p4485 {
	public static class Info implements Comparable<Info>{
		public int i;
		public int j;
		public int weight;
		public Info(int i, int j, int weight) {
			super();
			this.i = i;
			this.j = j;
			this.weight = weight;
		}
		
		public int compareTo(Info ii) {
			return weight - ii.weight;
		}
	}
	public static int N;
	public static int arr[][];
	public static int dist[][];
	public static int delta[][] = {
			{-1, 0},
			{1, 0},
			{0, -1},
			{0, 1}
	};
	public static PriorityQueue<Info> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) return;
			arr = new int[N][N];
			dist = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println("Problem "+(tc++)+": " + dijkstra());
		}
	}
	
	public static int dijkstra() {
		pq.clear();
		for(int i=0; i<N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		pq.offer(new Info(0, 0, arr[0][0]));
		
		while(!pq.isEmpty()) {
			Info info = pq.poll();
			for(int d=0; d<4; d++) {
				int ni = info.i + delta[d][0];
				int nj = info.j + delta[d][1];
				if(ni < 0 || ni >= N || nj < 0 || nj >= N || dist[ni][nj] <= info.weight + arr[ni][nj]) continue;
				if(ni == N-1 && nj == N-1) {
					return info.weight + arr[ni][nj];
				}
				
				dist[ni][nj] = info.weight + arr[ni][nj];
				pq.offer(new Info(ni, nj, info.weight + arr[ni][nj]));
			}
		}
		return dist[N-1][N-1];
	}

}
