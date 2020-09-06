

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p17472 {
	static class BuildSpot{
		public int i;
		public int j;
		public int island;
	}
	static int arr[][];
	static int N, M, cnt;
	static int delta[][] = {
			{-1, 0},
			{1, 0},
			{0, -1},
			{0, 1}
	};
	
	static boolean visit[][];
	static Queue<int[]> q = new LinkedList<>();
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
				if(st.nextToken().equals("1")) arr[i][j] = 1;
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] != 0 && !visit[i][j]) {
					getIslandNum(i, j);
				}
			}
		}
		
		
		
	}
	
	public static void getIslandNum(int i, int j) {
		cnt++;
		q.clear();
		
		q.offer(new int[] {i, j});
		visit[i][j] = true;
		arr[i][j] = cnt;
		
		while(!q.isEmpty()) {
			for(int d=0; d<4; d++) {
				int ni = q.peek()[0] + delta[d][0];
				int nj = q.peek()[1] + delta[d][1];
				
				if(canGo(ni, nj)) {
					arr[ni][nj] = cnt;
					visit[ni][nj] = true;
					q.offer(new int[] {ni, nj});
				}
			}
			q.poll();
		}
	}
	
	public static boolean canGo(int i, int j) {
		if(i < 0 || i>=N || j < 0 || j >= M || visit[i][j] || arr[i][j] == 0) return false;
		return true;
	}
	
}
