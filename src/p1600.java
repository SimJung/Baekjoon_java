import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1600 {
	public static class Info{
		public int i;
		public int j;
		public int horseMove;
		public int cnt;
		public Info(int i, int j, int h, int cnt) {
			super();
			this.i = i;
			this.j = j;
			horseMove = h;
			this.cnt = cnt;
		}
		
	}
	
	public static int W, H, K;
	public static int arr[][];
	public static boolean visit[][][];
	public static Queue<Info> q = new LinkedList<>();
	
	public static int delta[][] = {
			{-2, -1},
			{-2, 1},
			{-1, -2},
			{-1, 2},
			{1, -2},
			{1, 2},
			{2, -1},
			{2, 1},
			{-1, 0},
			{1, 0},
			{0, -1},
			{0, 1}
	};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		arr = new int[H][W];
		visit = new boolean[H][W][K+1];
		
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		q.offer(new Info(0, 0, 0, 0));
		visit[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Info info = q.poll();
			//System.out.println(info.i + " " + info.j);
			if(info.i == H-1 && info.j == W-1) {
				System.out.println(info.cnt);
				return ;
			}
			
			for(int d=0; d<8; d++) {
				int ni = info.i + delta[d][0];
				int nj = info.j + delta[d][1];
				
				if(ni < 0 || ni >= H || nj < 0 || nj >= W || arr[ni][nj] == 1 || info.horseMove >= K || visit[ni][nj][info.horseMove+1]) continue;
				
				visit[ni][nj][info.horseMove+1] = true;
				q.offer(new Info(ni, nj, info.horseMove+1, info.cnt+1));
			}
			
			for(int d=8; d<12; d++) {
				int ni = info.i + delta[d][0];
				int nj = info.j + delta[d][1];
				
				if(ni < 0 || ni >= H || nj < 0 || nj >= W || arr[ni][nj] == 1 || visit[ni][nj][info.horseMove]) continue;
				
				visit[ni][nj][info.horseMove] = true;
				q.offer(new Info(ni, nj, info.horseMove, info.cnt+1));
			}
		}
		
		System.out.println("-1");
	}

}
