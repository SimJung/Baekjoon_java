
import java.util.Scanner;
public class p4963 {
	static boolean[][] arr;
	static boolean[][] visit;
	static int[][] dir = {
			{-1, -1},
			{-1, 0},
			{-1, 1},
			{0, -1},
			{0, 1},
			{1, -1},
			{1, 0},
			{1, 1}
	};
	static int w, h;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		w = sc.nextInt();
		h = sc.nextInt();
		
		while(true) {
			int ans = 0;
			if(w == 0 && h == 0)
				return;
			
			arr = new boolean[h][w];
			visit = new boolean[h][w];
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					int temp = sc.nextInt();
					arr[i][j] = (temp == 1 ? true : false);
				}
			}
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(!visit[i][j] && arr[i][j]) {
						ans++;
						visit[i][j] = true;
						dfs(i, j);
					}
				}
			}
			
			
			
			System.out.println(ans);
			w = sc.nextInt();
			h = sc.nextInt();
		}
	}
	
	public static void dfs(int i, int j) {
		for(int k=0; k<8; k++) {
			int ni = i+dir[k][0];
			int nj = j + dir[k][1];
			if(ni >= h || ni < 0 || nj >= w || nj < 0 || visit[ni][nj] || !arr[ni][nj])
				continue;
			
			visit[ni][nj] = true;
			dfs(ni, nj);
		}
	}

}
