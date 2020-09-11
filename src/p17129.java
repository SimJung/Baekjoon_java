import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p17129 {
	static class Bird{
		public int i;
		public int j;
		public int time;
		public Bird(int i, int j, int time) {
			super();
			this.i = i;
			this.j = j;
			this.time = time;
		}
	}
	static int N, M, ans;
	static char arr[][];
	static Queue<Bird> q = new LinkedList<>();
	static boolean[][] visit;
	static int[][] delta = {
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
		arr= new char[N][];
		visit = new boolean[N][M];
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				if(arr[i][j] == '2') {
					q.offer(new Bird(i, j, 0));
					visit[i][j] = true;
				}
			}
		}
		ans = -1;
		bfs();
		if(ans == -1) System.out.println("NIE");
		else System.out.println("TAK\n"+ans);
	}
	static void bfs() {
		while(!q.isEmpty()) {
			Bird temp = q.poll();
			for(int d=0; d<4; d++) {
				int ni = temp.i + delta[d][0];
				int nj = temp.j + delta[d][1];
				
				if(ni < 0 || ni >= N || nj < 0 || nj >= M || visit[ni][nj] || arr[ni][nj] == '1') continue;
				
				if(arr[ni][nj] == '3' || arr[ni][nj] == '4' || arr[ni][nj] == '5') {
					ans = temp.time+1;
					return;
				}
				
				visit[ni][nj] = true;
				q.offer(new Bird(ni, nj, temp.time+1));
			}
		}
	}
}
