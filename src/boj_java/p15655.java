package boj_java;
import java.util.Scanner;
import java.util.Arrays;
public class p15655 {
	static int arr[];
	static int n, m;
	static int ans[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		ans = new int[m];
		
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		comb(0, 0);
	}
	
	public static void comb(int cnt, int idx) {
		if(cnt == m)
		{
			for(int i=0; i<cnt; i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println();
			return ;
		}
		
		for(int i=idx; i<n-m+cnt+1; i++) {
			ans[cnt] = arr[i];
			comb(cnt+1, i+1);
		}
	}
}
