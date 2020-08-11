
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
public class p15656 {
	static int N, M;
	static int[] ans;
	static int[] arr;
	static BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		ans = new int[M];
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		perm(0);
		bf.flush();
		bf.close();
	}
	
	public static void perm(int cnt) throws IOException {
		if(cnt == M) {
			for(int i=0; i<M; i++)
				bf.write(ans[i] + " ");
			bf.write("\n");
			return ;
		}
		
		for(int i=0; i<N; i++) {
			ans[cnt] = arr[i];
			perm(cnt+1);
		}
	}
}
