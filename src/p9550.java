import java.util.Scanner;

public class p9550 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		while(T-- > 0) {
			int N = sc.nextInt(), K = sc.nextInt();
			
			int ans = 0;
			for(int i=0; i<N; i++) {
				int temp = sc.nextInt();
				if(K <= temp) {
					if(temp > ans) ans = temp;
				}
			}
			
			System.out.println(ans);
		}
	}

}
