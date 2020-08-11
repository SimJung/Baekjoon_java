
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
public class p4386 {
	static int N;
	
	static class Star{
		public double x;
		public double y;
		
		Star(double a, double b){
			x = a;
			y = b;
		}
	}
	static class Edge{
		public int from;
		public int to;
		public double weight;
		
		Edge(int f, int t, double w){
			from = f;
			to = t;
			weight = w;
		}
	}
	
	static class MyComp implements Comparator<Edge>{
		public int compare(Edge a, Edge b) {
			if(a.weight > b.weight) return 1;
			else if(a.weight< b.weight) return -1;
			return 0;
		}
	}
	
	static Star[] stars;
	static ArrayList<Edge> edgeList = new ArrayList<>();
	static int[] parent;
	static int[] ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		stars = new Star[N];
		parent = new int[N];
		ans = new int[2];
		for(int i=0; i<N; i++) {
			stars[i] = new Star(sc.nextDouble(), sc.nextDouble());
		}
		comb(0, 0);
		
		for(int i=0; i<N; i++) {
			parent[i] = i;
		}
		
		Collections.sort(edgeList, new MyComp());
		
		int cnt = 0;
		double sum = 0;
		for(int i=0; i<edgeList.size(); i++) {
			if(union(edgeList.get(i).from, edgeList.get(i).to)) {
				cnt++;
				sum += edgeList.get(i).weight;
				
				if(cnt == N-1)
					break;
			}
		}
		System.out.println(Math.round(sum*100)/100.0);
	}
	
	public static void comb(int cnt, int idx) {
		if(cnt == 2) {
			double w = Math.sqrt((stars[ans[0]].x - stars[ans[1]].x) * (stars[ans[0]].x - stars[ans[1]].x) + (stars[ans[0]].y - stars[ans[1]].y) * (stars[ans[0]].y - stars[ans[1]].y));
			edgeList.add(new Edge(ans[0], ans[1], w));
			return ;
		}
		
		for(int i=idx; i<N; i++) {
			ans[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	
	public static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	public static boolean union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		
		if(rootX == rootY) return false;
		
		if(rootX > rootY) {
			parent[rootX] = rootY;
		}else
			parent[rootY] = rootX;
		
		return true;
	}

}
