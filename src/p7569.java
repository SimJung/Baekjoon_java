
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
public class p7569 {

	static int delta[][] = {
			{-1, 0, 0},
			{1, 0, 0},
			{0, -1, 0},
			{0, 1, 0},
			{0, 0, -1},
			{0, 0, 1}
	};
	
	static int tomato[][][];
	static int N, M, H, freshT = 0, time = 1;
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		tomato = new int[H][N][M];
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(bf.readLine());
				for(int k=0; k<M; k++) {
					tomato[i][j][k] = Integer.parseInt(st.nextToken());
					switch(tomato[i][j][k]) {
					case 0:
						freshT++;
						break;
						
					case 1:
						q.offer(new int[] {i, j, k});
						break;
					}
				}
			}
		}
		
		bfs();
		if(freshT == 0)
			System.out.println(time-1);
		else
			System.out.println("-1");
	}
	
	public static void bfs() {
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			for(int i=0; i<6; i++) {
				int ni = temp[0]+delta[i][0];
				int nj = temp[1]+delta[i][1];
				int nk = temp[2]+delta[i][2];
				
				if(ni >= H || ni < 0 || nj >= N || nj < 0 || nk >= M || nk < 0 || tomato[ni][nj][nk] != 0)
					continue;
				
				tomato[ni][nj][nk] = tomato[temp[0]][temp[1]][temp[2]]+1;
				q.offer(new int[] {ni, nj, nk});
				freshT--;
				if(time < tomato[ni][nj][nk]) time = tomato[ni][nj][nk];
			}
		}
	}
}
