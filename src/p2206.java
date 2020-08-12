import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
public class p2206 {
	static int N, M;
	static boolean arr[][];
	static Queue<int[]> q= new LinkedList<>();
	static int dir[][] = {
			{0, -1},
			{0, 1},
			{-1, 0},
			{1, 0}
	};
	
	static class Count{
		public int cnt = 0;
		public boolean wallBreak = false;
	}
	
	static Count[][] arrCount;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new boolean[N][M];
		arrCount = new Count[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				arrCount[i][j] = new Count();
			}
		}
		
		String temp;
		for(int i=0; i<N; i++) {
			temp = bf.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = (temp.charAt(j) == '1' ? true : false);
				arrCount[i][j].cnt = -1;
			}
		}
		
		arrCount[0][0].cnt = 0;
		q.offer(new int[] {0, 0});
		bfs();
		System.out.println(arrCount[N-1][M-1].cnt);
	}
	
	public static void bfs() {
		while(!q.isEmpty()) {
			int i = q.peek()[0];
			int j = q.peek()[1];
			q.poll();
			
			for(int k=0; k<4; k++) {
				int ni = i+dir[k][0];
				int nj = j+dir[k][1];
				if(ni >= N || ni <0 || nj >= M || nj < 0)
					continue;
				
				if(arrCount[i][j].wallBreak && arr[ni][nj])
					continue;
				
				if(arrCount[ni][nj].cnt != -1 && arrCount[i][j].cnt+1 >= arrCount[ni][nj].cnt)
					continue;
				
				arrCount[ni][nj].cnt = arrCount[i][j].cnt+1;
				if(arr[ni][nj])	arrCount[ni][nj].wallBreak = true;
				q.offer(new int[] {ni, nj});
			}
		}
	}

}
