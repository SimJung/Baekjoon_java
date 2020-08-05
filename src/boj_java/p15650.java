package boj_java;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class p15650 {
	static int N, M;
	static int[] ans;
	static BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		ans = new int[M];
		
		comb(0, 0);
		bf.flush();
		bf.close();
	}
	
	public static void comb(int cnt, int idx) throws IOException {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=idx; i<N; i++) {
			ans[cnt] = i+1;
			comb(cnt+1, i+1);
		}
	}
}
