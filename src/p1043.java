import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1043 {
	public static int N, M, ans;
	public static long flag, newFlag, party[];
	public static boolean visitH[], visitV[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		party = new long[M];
		visitH = new boolean[N+1];
		visitV = new boolean[M];
		
		
		st = new StringTokenizer(br.readLine());
		int truthNum = Integer.parseInt(st.nextToken());
		for(int i=0; i<truthNum; i++) {
			int temp = Integer.parseInt(st.nextToken());
			
			flag |= (long)((long)1<<temp);
		}
		
		newFlag = flag;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			for(int j=0; j<n; j++) {
				int temp = Integer.parseInt(st.nextToken());
				party[i] |= ((long)1 << temp);
			}
		}
		
		for(int i=1; i<=N; i++) {
			if((flag & ((long)1 << i)) != 0) {
				dfsVertical(i);
			}
		}
		
		for(int i=0; i<M; i++) {
			if((newFlag & party[i]) == 0) ans++;
		}
		
		System.out.println(ans);
	}
	
	public static void dfsVertical(int n) {
		newFlag |= ((long)1<<n);
		visitH[n] = true;
		for(int i=0; i<M; i++) {
			if(!visitV[i] && (party[i] & ((long)1 << n)) != 0) {
				dfsHorizon(i);
			}
		}
	}
	
	public static void dfsHorizon(int n) {
		visitV[n] = true;
		for(int i=1; i<=N; i++) {
			if(!visitH[i] && (party[n] & ((long)1<<i)) != 0) {
				dfsVertical(i);
			}
		}
	}

}
