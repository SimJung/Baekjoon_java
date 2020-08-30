import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p6591 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long n = Long.parseLong(st.nextToken());
			long k = Long.parseLong(st.nextToken());
			if(n == 0 && k == 0)
				return ;

			if(n - k < k) k = n - k;
			long temp = 1;
			int div = 1;
			
			while(k-- > 0) {
				temp *= n--;
				temp /= div++;
			}
			
			System.out.println(temp);
		}
	}

}
