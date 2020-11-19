import java.util.Scanner;

public class p13251 {
	public static int M, K, S;
	public static int arr[];
	public static double p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		
		arr = new int[M];
		for(int i=0; i<M; i++) {
			arr[i] = sc.nextInt();
			S += arr[i];
		}
		
		K = sc.nextInt();
		
		for(int i=0; i<M; i++) {
			double temp = 1;
			for(int j=0; j<K; j++) {
				temp *= ((double)arr[i] - (double)j) / ((double)S - (double)j);
			}
			p += temp;
		}
		
		System.out.println(p);
		
		
	}

}
