import java.util.Scanner;

public class p3985 {
	public static int L, N, pMan, rMan, pmaxVal, rmaxVal;
	public static boolean arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		N = sc.nextInt();
		arr = new boolean[L+1];
		for(int i=1; i<=N; i++) {
			int from, to;
			from = sc.nextInt();
			to = sc.nextInt();
			if(pmaxVal < to-from+1) {
				pmaxVal = to-from+1;
				pMan = i;
			}
			
			int sum = 0;
			for(int j=from; j<=to; j++) {
				if(!arr[j]) {
					sum++;
					arr[j] = true;
				}
			}
			
			if(sum > rmaxVal) {
				rmaxVal = sum;
				rMan = i;
			}
		}
		
		System.out.println(pMan);
		System.out.println(rMan);
	}

}
