import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p1194 {
	public static class Pos{
		public int i;
		public int j;
		public int key;
		public int count;
		public Pos(int i, int j, int count, int key) {
			super();
			this.i = i;
			this.j = j;
			this.count = count;
			this.key = key;
		}
		
	}
	public static int N, M;
	public static char arr[][];
	public static int visit[][];
	public static Queue<Pos> q = new LinkedList<>();
	public static int[][] delta = {
			{0, -1},
			{0, 1},
			{-1, 0},
			{1, 0}
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new char[N][];
		visit = new int[N][M];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.next().toCharArray();
			for(int j=0; j<M; j++) {
				if(arr[i][j] == '0') {
					arr[i][j] = '.';
					q.offer(new Pos(i, j, 0, 1));
					visit[i][j] = 1;
				}else if(arr[i][j] == '#') {
					visit[i][j] = 127;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int i = q.peek().i;
			int j = q.peek().j;
			int cnt = q.peek().count;
			int nowKey = q.peek().key;
			q.poll();
			if(arr[i][j] == '1') {
				System.out.println(cnt);
				return ;
			}
			
			for(int d=0; d<4; d++) {
				int ni = i + delta[d][0];
				int nj = j + delta[d][1];
				
				if(ni < 0 || ni >= N || nj < 0 || nj >= M || arr[ni][nj] == '#' ||(visit[ni][nj] & nowKey) == nowKey) continue;
				
				if(arr[ni][nj] >= 'A' && arr[ni][nj] <= 'F') {
					if((nowKey & (1<<(arr[ni][nj]-'A'+1))) == 0) continue;
				}
				
				if(arr[ni][nj] >= 'a' && arr[ni][nj] <= 'f') {
					q.offer(new Pos(ni, nj, cnt+1, nowKey|(1<<(arr[ni][nj]-'a'+1))));
					visit[ni][nj] = nowKey|(1<<(arr[ni][nj]-'a'+1));
				}else {
					q.offer(new Pos(ni, nj, cnt+1, nowKey));
					visit[ni][nj] = nowKey;
				}
			}
		}
		
		System.out.println("-1");
	}

}
