import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2638 {
	public static class Info{
		public int i;
		public int j;
		public Info(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
	}
	
	public static int N, M, T;
	public static int arr[][], cheese[][], delta[][] = {
			{0, -1},
			{0, 1},
			{-1, 0},
			{1, 0}
	};
	
	public static Queue<Info> qa = new LinkedList<>();
	public static Queue<Info> qc = new LinkedList<>();
	
	public static boolean visit[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visit = new boolean[N][M];
		cheese = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		qa.offer(new Info(0, 0));
		visit[0][0] = true;
		
		makeAir();
		melt();
		
		System.out.println(T);
	}
	
	public static void makeAir() {
		while(!qa.isEmpty()) {
			Info now = qa.poll();
			for(int d=0; d<4; d++) {
				int ni = now.i + delta[d][0];
				int nj = now.j + delta[d][1];
				
				if(ni < 0 || ni >= N || nj < 0 || nj >= M || visit[ni][nj]) continue;
				
				if(arr[ni][nj] == 1) {
					cheese[ni][nj]++;
					if(cheese[ni][nj] >= 2) {
						qc.offer(new Info(ni, nj));
						visit[ni][nj] = true;
					}
				}else {
					qa.offer(new Info(ni, nj));
					visit[ni][nj] = true;
				}
			}
		}
	}
	
	public static void melt() {
		while(!qc.isEmpty()) {
			int sz = qc.size();
			
			if(sz == 0) break;
			
			T++;
			
			for(int i=0; i<sz; i++) {
				Info now = qc.poll();
				
				for(int d=0; d<4; d++) {
					int ni = now.i + delta[d][0];
					int nj = now.j + delta[d][1];
					
					if(ni < 0 || ni >= N || nj < 0 || nj >= M || visit[ni][nj]) continue;
					
					if(arr[ni][nj] == 1) {
						cheese[ni][nj]++;
						if(cheese[ni][nj] >= 2) {
							qc.offer(new Info(ni, nj));
							visit[ni][nj] = true;
						}
					}else {
						qa.offer(new Info(ni, nj));
						visit[ni][nj] = true;
					}
				}
			}
			
			makeAir();
		}
	}

}
