import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p10026 {
	static int N, nonArea, area;
	static char[][] arr;
	static int[][] delta = {
			{-1, 0},
			{1, 0},
			{0, -1},
			{0, 1}
	};
	
	static boolean[][] visit;
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new char[N][];
		visit = new boolean[N][N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.next().toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j]) {
					nonArea++;
					bfs(i, j, true);
				}
			}
		}
		
		for(int i=0; i<N; i++) Arrays.fill(visit[i], false);
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j]) {
					area++;
					bfs(i, j, false);
				}
			}
		}
		
		System.out.println(nonArea+" "+area);
	}
	
	static void bfs(int i, int j, boolean canD) {
		q.clear();
		visit[i][j] = true;
		q.offer(new int[] {i, j});
		char chk = arr[i][j];
		while(!q.isEmpty()) {
			for(int d=0; d<4; d++) {
				int ni = q.peek()[0]+delta[d][0];
				int nj = q.peek()[1]+delta[d][1];
				
				if(ni < 0 || ni >= N || nj < 0 || nj >= N || visit[ni][nj]) continue;
				if(canD) {
					if(arr[ni][nj] != chk) continue;
				}else {
					if(chk == 'B' || arr[ni][nj] == 'B') {
						if(chk != arr[ni][nj]) continue;
					}
				}
				
				visit[ni][nj] = true;
				q.offer(new int[] {ni, nj});
			}
			q.poll();
		}
	}

}
