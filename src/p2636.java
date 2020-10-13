import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2636 {
	public static class Cheese{
		public int i;
		public int j;
		public int time;
		public Cheese(int i, int j, int time) {
			super();
			this.i = i;
			this.j = j;
			this.time = time;
		}
		
	}
	public static Queue<Cheese> q = new LinkedList<>();
	public static Queue<Cheese> air = new LinkedList<>();
	public static int N, M;
	public static int arr[][];
	public static boolean visit[][];
	public static int delta[][] = {
			{-1, 0},
			{1, 0},
			{0, -1},
			{0, 1}
	};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				if(st.nextToken().equals("1")) {
					arr[i][j] = 1;
				}
			}
		}
		
		air.offer(new Cheese(0, 0, 1));
		arr[0][0] = 2;
		//show();
		makeAir();
		
		/*
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 1) {
					for(int d=0; d<4; d++) {
						int ni = i + delta[d][0];
						int nj = j + delta[d][1];
						
						if(ni < 0 || ni >= N || nj < 0 || nj >= M || arr[ni][nj] != 2 || visit[i][j]) continue;
						
						q.offer(new Cheese(i, j, 1));
						visit[i][j] = true;
						break;
					}
				}
			}
		}
		*/
		
		
		int time = 0;
		int prevSize = 0;
		while(!q.isEmpty()) {
			prevSize = q.size();
			//show();
			
			for(int i=0; i<prevSize; i++) {
				Cheese now = q.poll();
				arr[now.i][now.j] = 2;
				for(int d=0; d<4; d++) {
					int ni = now.i + delta[d][0];
					int nj = now.j + delta[d][1];
					
					if(ni < 0 || ni >= N || nj < 0 || nj >= M || arr[ni][nj] == 2 || visit[ni][nj]) continue;
					
					if(arr[ni][nj] == 0) {
						air.offer(new Cheese(ni, nj, now.time+1));
					}else {
						q.offer(new Cheese(ni, nj, now.time+1));
						visit[ni][nj] = true;
					}
				}
				time = now.time;
			}
			
			makeAir();
		}
		System.out.println(time);
		System.out.println(prevSize);
	}
	
	static void show() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print((arr[i][j] != 1 ? " " : "■")+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void makeAir() {
		while(!air.isEmpty()) {
			Cheese now = air.poll();
			visit[now.i][now.j] = true;
			for(int d=0; d<4; d++) {
				int ni = now.i + delta[d][0];
				int nj = now.j + delta[d][1];
				
				if(ni < 0 || ni >= N || nj < 0 || nj >= M || visit[ni][nj]) continue;
				
				if(arr[ni][nj] == 0) {
					air.offer(new Cheese(ni, nj, now.time));
					arr[ni][nj] = 2;
				}else {
					q.offer(new Cheese(ni, nj, now.time));
					arr[ni][nj] = 2;
				}
				visit[ni][nj] = true;
			}
		}
	}
}
