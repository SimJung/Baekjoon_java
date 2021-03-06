
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
public class p15657 {
	static int N, M;
	static int[] arr;
	static int[] ans;
	static BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		ans = new int[M];
		
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		perm(0, 0);
		bf.flush();
		bf.close();
		
	}
	
	public static void perm(int cnt, int idx) throws IOException
	{
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				bf.write(ans[i]+" ");
			}
			bf.write("\n");
			return ;
		}
		
		for(int i=idx; i<N; i++) {
			ans[cnt] = arr[i];
			perm(cnt+1, i);
		}
	}
	
}

	
