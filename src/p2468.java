
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
public class p2468 {
	static int map[][];
	static int N, lowest = 101, highest = 0, ans;
	static boolean visit[][];
	static int dir[][] = {
			{0, 1},
			{0, -1},
			{1, 0},
			{-1, 0}
	};
	
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] < lowest) lowest = map[i][j];
				if(map[i][j] > highest) highest = map[i][j];
			}
		}
		
		for(int h = lowest-1; h<highest; h++) {
			visit = new boolean[N][N];
			int temp = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visit[i][j] && map[i][j] > h) {
						visit[i][j] = true;
						q.offer(new int[] {i, j});
						bfs(h);
						temp++;
					}
				}
			}
			
			if(ans < temp) ans = temp;
		}
		
		System.out.println(ans);
	}
	
	public static void bfs(int h) {
		while(!q.isEmpty()) {
			int i = q.peek()[0];
			int j = q.peek()[1];
			q.poll();
			for(int k=0; k<4; k++) {
				int ni = i + dir[k][0];
				int nj = j + dir[k][1];
				
				if(ni >= N || ni < 0 || nj >= N || nj < 0 || visit[ni][nj] || map[ni][nj] <= h)
					continue;
				
				visit[ni][nj] = true;
				q.offer(new int[] {ni, nj});
			}
			
		}
	}
}
