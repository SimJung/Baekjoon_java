import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p13023 {
	static int N, M;
	static ArrayList<Integer> edgeList[];
	static boolean[] visit;
	static boolean ans = false;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edgeList = new ArrayList[N];
		for(int i=0; i<N; i++) {
			edgeList[i] = new ArrayList<>();
		}
		visit = new boolean[N];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			edgeList[from].add(to);
			edgeList[to].add(from);
		}
		
		for(int i=0; i<N ;i++) {
			if(ans) break;
			dfs(i, 0);
		}
		
		System.out.println((ans ? "1" : "0"));
	}
	
	static void dfs(int n, int friend) {
		if(friend == 4 || ans) {
			ans = true;
			return ;
		}else {
			visit[n] = true;
			for(int i=0; i<edgeList[n].size(); i++) {
				if(ans) return;
				if(!visit[edgeList[n].get(i)]) dfs(edgeList[n].get(i), friend+1);
			}
			visit[n] = false;
		}
	}

}
