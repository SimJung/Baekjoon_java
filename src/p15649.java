
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
public class p15649 {
	static int N, M;
	static int[] ans;
	static boolean[] visit;
	static BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		visit = new boolean[N];
		ans = new int[M];
		
		perm(0);
		
		bf.flush();
		bf.close();
	}
	
	static void perm(int cnt) throws IOException{
		if(cnt == M) {
			for(int i=0; i<M; i++)
				bf.write(ans[i]+" ");
			bf.write("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				ans[cnt] = i+1;
				perm(cnt+1);
				visit[i] = false;
			}
		}
		
	}
}
