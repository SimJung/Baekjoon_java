package boj_java;
import java.util.Queue;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class p7576 {
	static int M, N, ans = 1, tomato;
	static int arr[][];
	static Queue<int[]> q;
	static boolean[][] visit;
	static int del[][] = {
			{0, -1},
			{0, 1},
			{-1, 0},
			{1, 0}
	};
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		q = new LinkedList<int[]>();
		arr = new int[N][M];
		visit = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				switch(arr[i][j]) {
				case 1:
					q.offer(new int[] {i, j});
				case -1:
					visit[i][j] = true;
					break;
				case 0:
					tomato++;
					break;
					
				}
			}
		}
		
		while(!q.isEmpty()) {
			int ti = q.peek()[0];
			int tj = q.peek()[1];
			q.poll();
			
			for(int i=0; i<4; i++) {
				int ni = ti + del[i][0];
				int nj = tj + del[i][1];
				if(ni >= N || ni < 0 || nj >= M || nj < 0 || visit[ni][nj])
					continue;
				
				arr[ni][nj] = arr[ti][tj] + 1;
				tomato--;
				if(ans < arr[ni][nj])
					ans = arr[ni][nj];
				q.offer(new int[] {ni, nj});
				visit[ni][nj] = true;
			}
		}

		
		if(tomato == 0)
			System.out.println(ans-1);
		else
			System.out.println("-1");
	}

}
