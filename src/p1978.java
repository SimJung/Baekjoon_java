
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class p1978 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		boolean arr[] = new boolean[1001];
		
		arr[0] = true;
		arr[1] = true;
		for(int i=2; i<1001; i++) {
			if(arr[i])
				continue;
			
			int val = 2;
			while(i*val <= 1000) {
				arr[i*val++] = true;
			}
		}
		
		int ans = 0;
		for(int i=0; i<N; i++) {
			if(arr[Integer.parseInt(st.nextToken())] == false)
				ans++;
		}
		System.out.println(ans);
	}

}
