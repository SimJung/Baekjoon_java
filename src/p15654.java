
import java.util.Scanner;
import java.util.Arrays;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
public class p15654 {
	
	static int n, m;
	static int[] arr;
	static boolean[] visit;
	static int[] ans;
	static BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n];
		visit = new boolean[n];
		ans = new int[m];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		perm(0);
		bf.flush();
		bf.close();
	}
	
	public static void perm(int cnt) throws IOException{
		if(cnt == m) {
			for(int i=0; i<m; i++)
				bf.write(ans[i] + " ");
			bf.write("\n");
			return ;
		}
		
		for(int i=0; i<n; i++) {
			if(!visit[i]) {
				ans[cnt] = arr[i];
				visit[i] = true;
				perm(cnt+1);
				visit[i] = false;
			}
		}
	}
}
