import java.util.Scanner;
public class p1987 {
	static int R, C, temp=0, ans=0;
	static char arr[][];
	static boolean visit[] = new boolean[26];
	static int delta[][] = {
			{-1, 0},
			{1, 0},
			{0, -1},
			{0, 1}
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		
		arr = new char[R][];
		for(int i=0; i<R; i++) {
			arr[i] = sc.next().toCharArray();
		}
		
		dfs(0, 0);
		System.out.println(ans);
	}
	
	public static void dfs(int i, int j) {
		visit[arr[i][j]-'A'] = true;
		temp++;
		
		if(temp > ans) {
			ans = temp;
		}
		
		for(int k=0; k<4; k++) {
			int ni = i + delta[k][0];
			int nj = j + delta[k][1];
			
			if(ni < 0 || ni >= R || nj < 0 || nj >= C || visit[arr[ni][nj] - 'A']) continue;
			
			dfs(ni, nj);
		}
		
		visit[arr[i][j]-'A'] = false;
		temp--;
	}
}
