import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class p2448 {
	public static int N;
	public static char arr[][];
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = sc.nextInt();
		arr = new char[N][N*2];
		for(int i=0; i<N; i++) {
			Arrays.fill(arr[i], ' ');
		}
		
		recur(N, N-1, 0);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N*2; j++) {
				bw.write(arr[i][j]);
			}
			bw.write('\n');
		}
		bw.flush();
		bw.close();
	}
	
	public static void recur(int n, int si, int sj) {
		if(n == 3) {
			for(int i=sj; i<sj+5; i++) {
				arr[si][i] = '*';
			}
			
			arr[si-1][sj+1] = '*';
			arr[si-1][sj+3] = '*';
			
			arr[si-2][sj+2] = '*';
			
		}else {
			recur(n/2, si, sj);
			recur(n/2, si, sj+n);
			recur(n/2, si-(n/2), sj+(n/2));
		}
	}
}
