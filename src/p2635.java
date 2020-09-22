import java.util.Scanner;

public class p2635 {
	static int arr[];
	static boolean show = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int maxVal = 0;
		arr = new int[N+1];
		for(int i=1; i<=N ;i++) {
			arr[i] = cnt(N, i, 2);
			if(arr[i] > maxVal) maxVal = arr[i];
		}
		
		System.out.println(maxVal);
		show = true;
		for(int i=1; i<=N; i++) {
			if(arr[i] == maxVal) {
				System.out.print(N+" "+i+" ");
				cnt(N, i, 2);
				break;
			}
		}
		System.out.println();
	}
	
	public static int cnt(int n1, int n2, int count) {
		if(n1 - n2 < 0) {
			return count;
		}
		else {
			if(show) {
				System.out.print(n1-n2+" ");
			}
			return cnt(n2, n1-n2, count+1);
		}
			
	}
}
