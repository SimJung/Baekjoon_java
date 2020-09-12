import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1389 {
	static int N, M, ans, ansBacon;
	static boolean arr[][];
	static int bacon[];
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new boolean[N+1][N+1];
		bacon = new int[N+1];
		ansBacon = Integer.MAX_VALUE;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from][to] = true;
			arr[to][from] = true;
		}
		
		for(int i=1; i<=N; i++) {
			bfs(i);
			int temp = 0;
			for(int j=1; j<=N; j++) {
				temp += bacon[j];
			}
			if(ansBacon > temp) {
				ansBacon = temp;
				ans = i;
			}
		}
		System.out.println(ans);
	}
	
	public static void bfs(int num) {
		q.clear();
		Arrays.fill(bacon, Integer.MAX_VALUE);
		q.offer(num);
		bacon[num] = 0;
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int i=1; i<=N; i++) {
				if(arr[temp][i] && bacon[i]>bacon[temp]+1) {
					bacon[i] = bacon[temp]+1;
					q.offer(i);
				}
			}
		}
	}
}
