import java.util.Scanner;

public class p2563 {
	static int N;
	static boolean[][] arr = new boolean[101][101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int tx = x; tx<x+10; tx++) {
				for(int ty = y; ty<y+10; ty++) {
					arr[tx][ty] = true;
				}
			}
		}
		
		int sum = 0;
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++){
				if(arr[i][j]) sum++;
			}
		}
		System.out.println(sum);
	}

}
