import java.util.Scanner;

public class p17070 {
	static int N, ans;
	static boolean arr[][];
	static int[][] delta = { { 0, 1 }, { 1, 1 }, { 1, 0 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = (sc.nextInt() == 1 ? true : false);
			}
		}

		recur(0, 1, 0);
		System.out.println(ans);
	}

	public static void recur(int i, int j, int p) {
		if (i == N - 1 && j == N - 1) {
			ans++;
			return;
		} else {
			int ni = i+1;
			int nj = j+1;
			if(!(ni >= N || nj >= N || arr[ni][j] || arr[i][nj] || arr[ni][nj])) {
				recur(ni, nj, 1);
			}
			switch (p) {
			case 0:
				ni = i;
				nj = j+1;
				if(!(ni >= N || nj >= N || arr[ni][nj])) {
					recur(ni, nj, 0);
				}
				break;

			case 1:
				ni = i;
				nj = j+1;
				if(!(ni >= N || nj >= N || arr[ni][nj])) {
					recur(ni, nj, 0);
				}
				
				ni = i+1;
				nj = j;
				if(!(ni >= N || nj >= N || arr[ni][nj])) {
					recur(ni, nj, 2);
				}
				break;

			case 2:
				ni = i+1;
				nj = j;
				if(!(ni >= N || nj >= N || arr[ni][nj])) {
					recur(ni, nj, 2);
				}
				break;
			}
		}
	}
}
