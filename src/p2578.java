import java.util.ArrayList;
import java.util.Scanner;

public class p2578 {
	static class C{
		public int i;
		public int j;
		public C(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static C[] arr;
	static boolean[][] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new C[26];
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				arr[sc.nextInt()] = new C(i, j);
			}
		}
		
		int num=0;
		visit = new boolean[5][5];
		for(int i=0; i<25; i++) {
			int temp = sc.nextInt();
			visit[arr[temp].i][arr[temp].j] = true;
			
			boolean hChk = true;
			for(int j=0; j<5; j++) {
				if(!visit[arr[temp].i][j]) {
					hChk = false;
					break;
				}
			}
			if(hChk) num++;
		
			
			boolean vChk = true;
			for(int j=0; j<5; j++) {
				if(!visit[j][arr[temp].j]) {
					vChk = false;
					break;
				}
			}
			if(vChk) num++;
			
			if(arr[temp].i == 2 && arr[temp].j == 2) {
				boolean ltChk = true;
				for(int j=0; j<5; j++) {
					if(!visit[j][j]) {
						ltChk = false;
						break;
					}
				}
				if(ltChk) num++;
				
				boolean lbChk = true;
				for(int j=0; j<5; j++) {
					if(!visit[4-j][j]) {
						lbChk = false;
						break;
					}
				}
				if(lbChk) num++;
			}
			else if(arr[temp].i + arr[temp].j == 4) {
				boolean lbChk = true;
				for(int j=0; j<5; j++) {
					if(!visit[4-j][j]) {
						lbChk = false;
						break;
					}
				}
				if(lbChk) num++;
			}else if(arr[temp].i == arr[temp].j) {
				boolean ltChk = true;
				for(int j=0; j<5; j++) {
					if(!visit[j][j]) {
						ltChk = false;
						break;
					}
				}
				if(ltChk) num++;
			}
			
			if(num >= 3) {
				System.out.println(i+1);
				return;
			}
		}
	}

}
