import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2559 {
	static int arr[], N, K, ans=Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
			if(i >= K) {
				sum -= arr[i-K];
				
				//	System.out.println(i+" : "+sum);
			}
			if(ans < sum && i >=K-1) ans = sum;
		}
		System.out.println(ans);
		
	}

}
