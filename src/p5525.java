import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p5525 {
	static int N;
	static int M;
	static StringBuilder sb;
	static int arr[];
	static int ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		sb = new StringBuilder(br.readLine());
		arr = new int[M];
		
		for(int i=1; i<M; i++) {
			if(sb.charAt(i) == 'I') {
				if(sb.charAt(i-1) == 'O') {
					arr[i] = arr[i-1];
					if(arr[i] >= N) ans++;
				}else {
					arr[i] = 0;
				}
			}else {
				if(sb.charAt(i-1) == 'I') {
					arr[i] = arr[i-1]+1;
				}else {
					arr[i] = 0;
				}
			}
		}
		
		System.out.println(ans);
	}

}
