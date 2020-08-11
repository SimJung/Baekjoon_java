
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
public class p11659 {
	static int N, M;
	static int arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		st = new StringTokenizer(bf.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(bf.readLine());
			int f = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken());
			
			if(f == t) {
				bw.write((arr[f] - arr[f-1])+"\n");
			}else {
				bw.write((arr[t] - arr[f-1]) + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
