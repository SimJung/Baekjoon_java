import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class p2206 {
	public static class Info{
		public int i;
		public int j;
		public int cnt;
		public int wallBreak;
		public Info(int i, int j, int cnt, int wallBreak) {
			super();
			this.i = i;
			this.j = j;
			this.cnt = cnt;
			this.wallBreak = wallBreak;
		}
		
	}
	public static int N, M;
	public static char arr[][];
	public static int visit[][][];
	public static Queue<Info> q = new LinkedList<>();
	public static int delta[][] = {
			{0, -1},
			{0, 1},
			{-1, 0},
			{1, 0},
	};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new int[N][M][2];
		arr = new char[N][];
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine().toCharArray();
			
			for(int j=0; j<M; j++) {
				visit[i][j][0] = Integer.MAX_VALUE;
				visit[i][j][1] = Integer.MAX_VALUE;
			}
		}
		
		visit[0][0][0] = 1;
		q.offer(new Info(0, 0, 1, 0));
		
		while(!q.isEmpty()) {
			Info now = q.poll();
			if(now.i == N-1 && now.j == M-1) {
				//show();
				System.out.println(now.cnt);
				return ;
			}
			
			for(int d=0; d<4; d++) {
				int ni = now.i + delta[d][0];
				int nj = now.j + delta[d][1];
				
				if(ni < 0 || ni >= N || nj < 0 || nj >= M) continue;
				
				if(arr[ni][nj] == '1') {
					if(now.wallBreak == 1 || visit[ni][nj][1] <= now.cnt+1) continue;	
				}else {
					if(visit[ni][nj][now.wallBreak] <= now.cnt+1) continue;
				}
				
				
				if(arr[ni][nj] == '1') {
					visit[ni][nj][1] = now.cnt+1;
					q.offer(new Info(ni, nj, now.cnt+1, 1));
				}else {
					visit[ni][nj][now.wallBreak] = now.cnt+1;
					q.offer(new Info(ni, nj, now.cnt+1, now.wallBreak));
				}
			}
		}
		
		//show();
		
		
		System.out.println("-1");
	}
	
	public static void show() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print("("+visit[i][j][0]+","+visit[i][j][1]+") ");
			}
			System.out.println();
		}
	}
}
