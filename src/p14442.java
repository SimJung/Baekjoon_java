import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p14442 {
	static class Info{
		public int dist;
		public boolean visit;
	}
	static int delta[][] = {
			{-1, 0},
			{1, 0},
			{0, -1},
			{0, 1}
	};
	static int N, M, K, ans;
	static boolean arr[][];
	static Info count[][][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j = 0; j<M; j++) {
				arr[i][j] = (str.charAt(j) == '1' ? true : false);
			}
		}
		
		ans = Integer.MAX_VALUE;
		count = new Info[N][M][K+1];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				for(int l=0; l<=K; l++) {
					count[i][j][l] = new Info();
				}
			}
		}
		
		bfs();
		for(int i=0; i<=K; i++) {
			if(count[N-1][M-1][i].dist != 0 && count[N-1][M-1][i].dist < ans)
				ans = count[N-1][M-1][i].dist;
		}
		System.out.println((ans == Integer.MAX_VALUE ? -1 : ans));
	}
	
	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0, 0});
		count[0][0][0].dist = 1;
		count[0][0][0].visit = true;
		
		while(!q.isEmpty()) {
			int i = q.peek()[0];
			int j = q.peek()[1];
			int k = q.peek()[2];
			q.poll();
			for(int d=0; d<4; d++) {
				int ni = i+delta[d][0];
				int nj = j+delta[d][1];
				if(ni < 0 || ni >= N || nj <0 || nj >= M) continue;
				if(arr[ni][nj]) {
					if(k >= K || count[ni][nj][k+1].visit) continue;
				}else {
					if(count[ni][nj][k].visit) continue;
				}
				
				if(arr[ni][nj]) {
					count[ni][nj][k+1].dist = count[i][j][k].dist+1;
					count[ni][nj][k+1].visit = true;
					q.offer(new int[] {ni, nj, k+1});
				}else {
					count[ni][nj][k].dist = count[i][j][k].dist+1;
					count[ni][nj][k].visit = true;
					q.offer(new int[] {ni, nj, k});
				}
				
				
			}
		}
	}
}
