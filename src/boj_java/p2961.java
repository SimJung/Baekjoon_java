package boj_java;
import java.util.Scanner;
public class p2961 {
	static int bitter[];
	static int sour[];
	static boolean ans[];
	static long answer = 1000000001;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		bitter = new int[N];
		sour = new int[N];
		ans = new boolean[N];
		for(int i=0; i<N; i++) {
			sour[i] = sc.nextInt();
			bitter[i] = sc.nextInt();
		}
		
		make_food(0);
		System.out.println(answer);
	}
	
	public static void make_food(int cnt) {
		if(cnt == N) {
			long b = 0, s = 1, sum;
			boolean chk = false;
			for(int i=0; i<N; i++) {
				if(ans[i]) {
					b += bitter[i];
					s *= sour[i];
					chk = true;
				}
				
			}
			sum = Math.abs(b - s);
			if(chk && sum < answer) answer = sum;
		}else {
			ans[cnt] = true;
			make_food(cnt+1);
				
			ans[cnt] = false;
			make_food(cnt+1);
		}
	}
}
