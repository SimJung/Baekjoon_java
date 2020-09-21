import java.util.Scanner;

public class p10157 {
	static int[][] dir = {
			{-1, 0},
			{0, 1},
			{1, 0},
			{0, -1}
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();
		int R = sc.nextInt();
		int K = sc.nextInt();
		int i=R-1, j=0, d=0, start=0;
		int arr[][] = new int[R][C];
		if(K > R*C) {
			System.out.println("0");
			return ;
		}else {
			while(true) {
				arr[i][j] = ++start;
				if(start == K) {
					System.out.println((j+1)+" "+(R-i));
					return ;
				}
				int ni = i + dir[d][0];
				int nj = j + dir[d][1];
				if(ni < 0 || ni >= R || nj < 0 || nj >= C || arr[ni][nj] != 0) {
					d++;
					if(d == 4) d = 0;
					
					ni = i + dir[d][0];
					nj = j + dir[d][1];
				}
				i = ni;
				j = nj;
			}
		}
	}

}
