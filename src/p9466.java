import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class p9466 {

	static int parent[];
	static int N;
	static boolean secondChoice[];
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		while(T-- > 0) {
			N = Integer.parseInt(bf.readLine());
			parent = new int[N+1];
			secondChoice = new boolean[N+1];
			make_set();
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int i=1; i<=N; i++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp != i && secondChoice[temp]) {
					parent[i] = -1;
					continue;
				}
				if(temp == i) parent[find(i)] = 0;
				else union(i, temp);
				
				secondChoice[temp] = true;
			}
			
			int cnt = 0;
			for(int i=1; i<=N; i++) {
				if(parent[i] == -1 || (parent[i] != 0 && parent[find(i)] == 0) || parent[find(i)] == -1) cnt++;
			}
			
			System.out.println(cnt);
		}
	}
	
	static void make_set() {
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
	}
	
	static int find(int x) {
		if(parent[x] == x || parent[x]==0) return x;
		else return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if(rootX == rootY) return;
		
		if(parent[rootX] == 0) parent[rootY] = rootX;
		else if(parent[rootY] == 0) parent[rootX] = rootY;
		else if(rootX > rootY) parent[rootX] = rootY;
		else parent[rootY] = rootX;
	}
}
