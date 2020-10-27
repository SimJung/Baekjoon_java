import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p18119 {
	public static int N, M, flag = ~0;
	public static int arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<s.length(); j++) {
				arr[i] |= (1 << s.charAt(j) - 'a');
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int c = st.nextToken().charAt(0) - 'a';
			
			if(n == 1) {
				 flag &= ~(1<<c);
			}else {
				flag |= (1<<c);
			}
			
			int ans = 0;
			for(int j=0; j<N; j++) {
				if((flag & arr[j]) == arr[j]) ans++;
			}
			
			bw.write(ans+"\n");
			
		}
		bw.flush();
		bw.close();
	}

}
