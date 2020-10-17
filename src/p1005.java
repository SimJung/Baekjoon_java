import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1005 {
	public static int cost[];
	public static int toBuild[];
	public static ArrayList<Integer> edges[];
	//public static boolean visit[];
	public static Queue<Integer> q = new LinkedList<>();
	public static int dpCost[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int N, K, W;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			cost = new int[N+1];
			toBuild = new int[N+1];
			edges = new ArrayList[N+1];
			for(int i=0; i<=N; i++) {
				edges[i] = new ArrayList<>();
			}
			//visit = new boolean[N];
			q.clear();
			dpCost = new int[N+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x, y;
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				
				toBuild[y]++;
				edges[x].add(y);
			}
			
			W = Integer.parseInt(br.readLine());
			
			for(int i=1; i<=N; i++) {
				if(toBuild[i] == 0) {
					q.offer(i);
					dpCost[i] = cost[i];
					//visit[i] = true;
				}
			}
			
			while(!q.isEmpty()) {
				int nowBuilding = q.poll();
				for(int i=0; i<edges[nowBuilding].size(); i++) {
					int nextB = edges[nowBuilding].get(i);
					dpCost[nextB] = (dpCost[nextB] > dpCost[nowBuilding] + cost[nextB] ? dpCost[nextB] : dpCost[nowBuilding] + cost[nextB]);
					if(--toBuild[edges[nowBuilding].get(i)] == 0) {
						q.offer(nextB);
					}
				}
			}
			
			System.out.println(dpCost[W]);
		}
	}

}
