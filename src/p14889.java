import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p14889 {
	static int N, ans;
	static int arr[][];
	static boolean t[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		ans = Integer.MAX_VALUE;
		t = new boolean[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0);
		System.out.println(ans);
	}
	public static void comb(int cnt, int idx) {
		if(cnt == N/2) {
			ArrayList<Integer> team1 = new ArrayList<>();
			ArrayList<Integer> team2 = new ArrayList<>();
			for(int i=0; i<N; i++) {
				if(t[i]) {
					team1.add(i);
				}else {
					team2.add(i);
				}
			}
			
			int t1 = 0, t2 = 0;
			for(int i=0; i<(N/2)-1; i++) {
				for(int j=i+1; j<N/2; j++) {
					t1 += arr[team1.get(i)][team1.get(j)]+arr[team1.get(j)][team1.get(i)];
					t2 += arr[team2.get(i)][team2.get(j)]+arr[team2.get(j)][team2.get(i)];
				}
			}
			if(Math.abs(t1-t2) < ans) ans = Math.abs(t1-t2);
		}else {
			for(int i=idx; i<N; i++) {
				t[i] = true;
				comb(cnt+1, i+1);
				t[i] = false;
			}
		}
	}
}
