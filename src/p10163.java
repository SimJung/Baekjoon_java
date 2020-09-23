import java.util.Scanner;

public class p10163 {
	static int arr[][]=new int[101][101];
	static int ans[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ans = new int[N+1];
		for(int i=1; i<=N; i++) {
			int a, b, c, d;
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			d = sc.nextInt();
			
			for(int j=a; j<a+c; j++) {
				for(int k=b; k<b+d; k++) {
					arr[j][k] = i;
				}
			}
		}
		
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				ans[arr[i][j]]++;
			}
		}
		
		for(int i=1; i<=N; i++) {
			System.out.println(ans[i]);
		}
	}

}
