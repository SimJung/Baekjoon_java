package boj_java;
import java.util.Scanner;
import java.util.Arrays;
public class p15654 {
	
	static int n, m;
	static int[] arr;
	static boolean[] visit;
	static int[] ans;
	public static void main(String[] args) {
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
	}
	
	public static void perm(int cnt) {
		if(cnt == m) {
			for(int i=0; i<m; i++)
				System.out.print(ans[i] + " ");
			System.out.println();
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
