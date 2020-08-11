

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class p15651 {
	static BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M;
	static int[] ans;
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		ans = new int[N];
		perm(0);
		bf.flush();
		bf.close();
	}
	
	public static void perm(int cnt) throws IOException{
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				bf.write(ans[i]+" ");
			}
			bf.write("\n");
			return ;
		}
		
		for(int i=0; i<N; i++) {
			ans[cnt] = i+1;
			perm(cnt+1);
		}
	}
}
