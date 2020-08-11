
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class p2667 {
	
	static int dir[][] = {
			{0, -1},
			{0, 1},
			{-1, 0},
			{1, 0}
	};
	
	static boolean arr[][];
	static boolean visit[][];
	static int N, temp = 0;
	static ArrayList<Integer> ans = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new boolean[N][N];
		visit = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String temp = sc.next();
			for(int j=0; j<N; j++) {
				if(temp.charAt(j) == '1') arr[i][j] = true;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j] && arr[i][j]) {
					temp = 0;
					visit[i][j] = true;
					dfs(i, j);
					if(temp != 0)
						ans.add(temp);
				}
			}
		}
		
		Collections.sort(ans);
		System.out.println(ans.size());
		for(int i=0; i<ans.size(); i++)
			System.out.println(ans.get(i));
	}
	
	public static void dfs(int i, int j) {
		temp++;
		for(int k=0; k<4; k++) {
			int ni = i + dir[k][0];
			int nj = j + dir[k][1];
			
			if(ni >= N || ni < 0 || nj >= N || nj < 0 || visit[ni][nj] || arr[ni][nj] == false)
				continue;
			
			visit[ni][nj] = true;
			dfs(ni, nj);
		}
	}
}
