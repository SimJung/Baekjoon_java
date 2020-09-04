import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p17471 {
	static int N, ans;
	static int populations[];
	static boolean city[][];
	static Queue<Integer> q = new LinkedList<>();
	static boolean visit[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		populations = new int[N];
		city = new boolean[N][N];
		visit = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			populations[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			for(int j=0; j<temp; j++) {
				int v = Integer.parseInt(st.nextToken()) - 1;
				city[i][v] = true;
				city[v][i] = true;
			}
		}
		
		ans = Integer.MAX_VALUE;
		for(int flag = 1; flag < (int)(Math.pow(2, N) - 1); flag++){
			check(flag);
		}
		System.out.println((ans == Integer.MAX_VALUE ? "-1" : ans));
	}
	
	public static void check(int flag) {
		int q1 = -1, q1sz = 0, q1pop = 0;
		int q2 = -1, q2sz = 0, q2pop = 0;
		for(int i=0; i<N; i++) {
			if((flag & 1 << i) != 0) {
				if(q1 == -1) q1 = i;
				q1sz++;
				q1pop += populations[i];
			}else if((flag & 1 << i) == 0){
				if(q2 == -1) q2 = i;
				q2sz++;
				q2pop += populations[i];
			}
		}
		
		if(bfs(q1, flag, q1sz) && bfs(q2, ~flag, q2sz)) {
			int popVal = Math.abs(q1pop - q2pop);
			if(ans > popVal) ans = popVal;
		}		
	}
	
	public static boolean bfs(int start, int flag, int sz) {
		int nowsz = 1;
		q.clear();
		Arrays.fill(visit, false);
		
		visit[start] = true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			int top = q.poll();
			for(int i=0; i<N; i++) {
				if((flag & 1 << i) != 0 && city[top][i] && !visit[i]) {
					nowsz++;
					if(nowsz == sz) return true;
					visit[i] = true;
					q.offer(i);
				}
			}
		}
		if(nowsz == sz) return true;
		else return false;
	}
}

