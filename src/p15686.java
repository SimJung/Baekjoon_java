import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p15686 {
	static class Spot {
		public int i,j;

		public Spot(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static int N, M;
	static ArrayList<Spot> houses = new ArrayList<>();
	static ArrayList<Spot> chickens = new ArrayList<>();
	static int[] comb;
	static boolean[] use;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int val = Integer.parseInt(st.nextToken());
				if(val == 1) houses.add(new Spot(i, j));
				else if(val == 2) chickens.add(new Spot(i, j));
			}
		}
		
		comb = new int[M];
		use = new boolean[chickens.size()];
		getComb(0, 0);
		System.out.println(ans);
	}
	
	public static void getComb(int cnt, int idx) {
		if(cnt == M) {
			int tempSum = 0;
			for(int i=0; i<M; i++) {
				use[comb[i]] = true;
			}
			for(Spot s : houses) {
				int minVal = Integer.MAX_VALUE;
				for(int i=0; i<chickens.size(); i++) {
					if(!use[i]) continue;
					int temp = getDist(s, chickens.get(i));
					if(temp < minVal) minVal = temp;
				}
				tempSum += minVal;
			}
			if(ans > tempSum) ans = tempSum;
			for(int i=0; i<M; i++) {
				use[comb[i]] = false;
			}
		}else {
			for(int i=idx; i<chickens.size(); i++) {
				comb[cnt] = i;
				getComb(cnt+1, i+1);
			}
		}
	}
	
	public static int getDist(Spot from, Spot to) {
		return Math.abs(from.i - to.i) + Math.abs(from.j - to.j);
	}
}
