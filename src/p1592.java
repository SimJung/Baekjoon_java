import java.util.Scanner;

public class p1592 {
	static int N, M, L;
	static int arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();
		
		arr = new int[N];
		
		int nowBall = 0, ans = 0;
		while(true) {
			arr[nowBall]++;
			if(arr[nowBall] == M) {
				break;
			}
			if(arr[nowBall] % 2 == 0) {
				nowBall-=L;
				if(nowBall < 0) nowBall += N;
			}else {
				nowBall+=L;
				if(nowBall >= N) nowBall -= N;
			}
			ans++;
		}
		System.out.println(ans);
	}

}
