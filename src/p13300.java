import java.util.Scanner;

public class p13300 {
	static int N, K;
	static int arr[][] = new int[6][2];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			int s = sc.nextInt();
			int g = sc.nextInt();
			arr[g-1][s]++;
		}
		
		int sum = 0;
		for(int i=0; i<6; i++) {
			for(int j=0; j<2; j++) {
				if(arr[i][j] % K != 0) {
					sum++;
				}
				sum += arr[i][j]/K;
			}
		}
		System.out.println(sum);
	}

}
