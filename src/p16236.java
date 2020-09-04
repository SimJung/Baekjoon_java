import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class p16236 {
	static class Shark implements Comparable<Shark>{
		public int i;
		public int j;
		public int time;
		public Shark(int i, int j, int time) {
			this.i = i;
			this.j = j;
			this.time = time;
		}
		
		@Override
		public int compareTo(Shark s) {
			if(time != s.time) return time - s.time;
			else if(i != s.i) return i - s.i;
			else if(j != s.j) return j - s.j;
			return 0;
		}
	}
	static int N, nowSize = 2, ans, nowI, nowJ, eat;
	static int arr[][];
	static boolean visit[][];
	static Queue<Shark> q = new LinkedList<>();
	static int delta[][] = {
			{-1, 0},
			{0, -1},
			{0, 1},
			{1, 0}
			
	};
	static PriorityQueue<Shark> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 9) {
					nowI = i;
					nowJ = j;
					arr[i][j] = 0;
				}
			}
		}
		
		while(true) {
			bfs();
			if(pq.isEmpty()) break;
			Shark s = pq.poll();
			ans += s.time;
			arr[s.i][s.j] = 0;
			eat++;
			nowI = s.i;
			nowJ = s.j;
			if(eat == nowSize) {
				nowSize++;
				eat = 0;
			}
			
			/*
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i == nowI && j == nowJ)
						System.out.print("9 ");
					else
						System.out.print(arr[i][j] + " ");
					
				}
				System.out.println();
			}
			System.out.println();
			*/
		
		}
		
		System.out.println(ans);
	}
	
	public static void bfs() {
		q.clear();
		pq.clear();
		for(int i=0; i<N; i++) {
			Arrays.fill(visit[i], false);
		}
		visit[nowI][nowJ] = true;
		q.offer(new Shark(nowI, nowJ, 0));
		while(!q.isEmpty()) {
			Shark temp = q.poll();
			for(int d=0; d<4; d++) {
				int ni = temp.i + delta[d][0];
				int nj = temp.j + delta[d][1];
				if(canGo(ni, nj)) {
					if(arr[ni][nj] != 0 && arr[ni][nj] < nowSize) {
						pq.offer(new Shark(ni, nj, temp.time+1));
					}else {
						visit[ni][nj] = true;
						q.offer(new Shark(ni, nj, temp.time+1));
					}
				}
			}
		}
	}
	
	public static boolean canGo(int i, int j) {
		if(i < 0 || i >= N || j < 0 || j >= N || visit[i][j] || arr[i][j] > nowSize) return false;
		return true;
	}
}
