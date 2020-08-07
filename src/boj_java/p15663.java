package boj_java;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;
public class p15663 {
	static int[] arr;
	static int[] ans;
	static boolean[] visit;
	static HashSet<int[]> arrList;
	static int N, M;
	static BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		visit = new boolean[N];
		arrList = new HashSet<>();
		ans = new int[M];
		//for(int i=0; i<M; i++) ans.add(0);
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		perm(0);
		for(int[] a : arrList) {
			bf.write(a[0] + " " + a[1]+"\n");
		}
		bf.flush();
		bf.close();
	}
	
	public static void perm(int cnt) {
		if(cnt == M) {
			int temp[] = ans;
			arrList.add(temp);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				ans[cnt] = arr[i];
				perm(cnt+1);
				visit[i] = false;
			}
		}
	}

}
