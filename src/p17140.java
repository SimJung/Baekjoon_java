import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p17140 {
	public static class Info{
		public int num;
		public int cnt;
		public Info(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
		
	}
	public static int R, C, K, nowR, nowC, T;
	public static int arr[][] = new int[101][101];
	public static ArrayList<>
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		K = sc.nextInt();
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		while(arr[R][C] != K && T++ < 100) {
			if(nowR >= nowC) {
				func(true);
			}else {
				func(false);
			}
		}
		
		
	}
	
	public static void func(boolean isR) {
		int toI, toJ;
		if(isR) {
			toI = nowR;
			toJ = nowC;
		}else {
			toI = nowC;
			toJ = nowR;
		}
		for(int i=0; i<toI; i++) {
			int cnt = 0;
			for(int j=0; j<toJ; j++) {
				int temp = 0;
				
				if(isR) {
					temp = arr[i][j];
				}else {
					temp = arr[j][i];
				}
				
				sum[temp]++;
				
				
				if(temp != 0) cnt++;
			}
			
			if(isR) {
				nowC = (nowC < cnt ? cnt : nowC);
			}else {
				nowR = (nowR < cnt ? cnt : nowR);
			}
		}
	}
}
