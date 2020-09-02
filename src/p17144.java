import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p17144 {
	static class Dust{
		public int i;
		public int j;
		public int dust;
		public Dust(int i, int j, int dust) {
			this.i = i;
			this.j = j;
			this.dust = dust;
		}
	}
	static int R, C, T, ans;
	static int arr[][];
	static ArrayList<int[][]> airCleaner = new ArrayList<>();
	static Queue<Dust> q = new LinkedList<>();
	static int[][] delta = {
			{0, -1},
			{0, 1},
			{-1, 0},
			{1, 0}
	};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		boolean airCChk = false;
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == -1 && !airCChk) {
					airCleaner.add(new int[][] {{i, j}, {i+1, j}});
					airCChk = true;
				}else if(arr[i][j] >= 5) {
					q.offer(new Dust(i, j, arr[i][j]));
				}else if(arr[i][j] == -1) airCChk = false;
			}
		}
		
		clean();
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j] > 0) ans+=arr[i][j];
			}
		}
		System.out.println(ans);
		
	}
	static void clean() {
		while(T-- > 0) {
			int sz = q.size();
			for(int i=0; i<sz; i++) {
				int dust = q.peek().dust;
				for(int d=0; d<4; d++) {
					int ni = q.peek().i + delta[d][0];
					int nj = q.peek().j + delta[d][1];
					
					if(ni < 0 || ni >= R || nj < 0 || nj >= C || arr[ni][nj] == -1) continue;
					
					arr[ni][nj] += dust/5;
					arr[q.peek().i][q.peek().j] -= dust/5;
				}
				q.poll();
			}
			
			/*
			System.out.println("먼지풀풀");
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			*/
			

			for(int a=0; a<airCleaner.size(); a++) {
				int up_i = airCleaner.get(a)[0][0];
				int up_j = airCleaner.get(a)[0][1]+1;
				int up_next = 0, up_prev = 0;
								
				while(true) {
					if(up_i == airCleaner.get(a)[0][0] && up_j == airCleaner.get(a)[0][1]) break;
					up_next = arr[up_i][up_j];
					arr[up_i][up_j] = up_prev;
					up_prev = up_next;
					
					if(up_i == 0 && up_j > 0) up_j--;
					else if(up_j == 0) up_i++;
					else if(up_i == airCleaner.get(a)[0][0] && up_j < C-1) up_j++;
					else if(up_j == C-1 && up_i > 0) up_i--;
				}
				
				int down_i = airCleaner.get(a)[1][0];
				int down_j = airCleaner.get(a)[1][1]+1;
				int down_next = 0, down_prev = 0;
				
				while(true) {
					if(down_i == airCleaner.get(a)[1][0] && down_j == airCleaner.get(a)[1][1]) break;
					down_next = arr[down_i][down_j];
					arr[down_i][down_j] = down_prev;
					down_prev = down_next;
					
					if(down_i == R-1 && down_j > 0) down_j--;
					else if(down_j == 0) down_i--;
					else if(down_i == airCleaner.get(a)[1][0] && down_j < C-1) down_j++;
					else if(down_j == C-1 && down_i < R-1) down_i++;
				}
			}
			
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(arr[i][j] >= 5) q.offer(new Dust(i, j, arr[i][j]));
				}
			}
			
			/*
			System.out.println("청소 끝");
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			*/
		}
	}
}
