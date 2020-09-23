import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p14696 {
	static int N;
	static int arrA[] = new int[4], arrB[] = new int[4];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			Arrays.fill(arrA, 0);
			Arrays.fill(arrB, 0);
			
			int d = Integer.parseInt(st.nextToken());
			for(int j=0; j<d; j++) {
				arrA[Integer.parseInt(st.nextToken())-1]++;
			}
			
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			for(int j=0; j<d; j++) {
				arrB[Integer.parseInt(st.nextToken())-1]++;
			}
			
			int res = 0;
			for(int j=3; j>=0; j--) {
				if(arrA[j] == arrB[j]) continue;
				else if(arrA[j] > arrB[j]) {
					res = 1;
					break;
				}else {
					res = 2;
					break;
				}
			}
			if(res == 1) {
				System.out.println("A");
			}else if(res == 2) {
				System.out.println("B");
			}else {
				System.out.println("D");
			}
		}
	}

}
