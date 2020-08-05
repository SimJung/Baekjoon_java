package boj_java;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class p15809 {
	static int[][] parent; 
	static int N, M, ans;
	static ArrayList<Integer> arr = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[2][N+1];
		for(int i=1; i<=N; i++) {
			parent[0][i] = i;
			parent[1][i] = Integer.parseInt(bf.readLine());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(bf.readLine());
			int o = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			if(o == 1) {
				union(p,q);
			}else {
				war(p,q);
			}
		}
		
		for(int i=1; i<=N; i++) {
			findS(i);
			if(parent[0][i] == i) {
				ans++;
				arr.add(parent[1][i]);
			}
		}
		System.out.println(ans);
		Collections.sort(arr);
		for(int i=0; i<arr.size(); i++)
			System.out.print(arr.get(i) + " ");
		System.out.println();
	}
	
	public static int find(int x) {
		if(parent[0][x] == x) return x;
		return parent[0][x] = find(parent[0][x]);
	}
	
	public static int findS(int x) {
		if(parent[0][x] == x) return parent[1][x];
		return parent[1][x] = findS(parent[0][x]);
	}
	
	public static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		
		if(rootX == rootY) return;
		if(rootX > rootY) {
			parent[0][rootX] = rootY;
			parent[1][rootY] += parent[1][rootX];
			parent[1][rootX] = 0;
		}else {
			parent[0][rootY] = rootX;
			parent[1][rootX] += parent[1][rootY];
			parent[1][rootY] = 0;
		}
	}
	
	
	public static void war(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		
		if(parent[1][rootX] > parent[1][rootY]) {
			parent[0][rootY] = rootX;
			parent[1][rootX] -= parent[1][rootY];
			parent[1][rootY] = 0;
		}else if(parent[1][rootX] < parent[1][rootY]) {
			parent[0][rootX] = rootY;
			parent[1][rootY] -= parent[1][rootX];
			parent[1][rootX] = 0;
		}else {
			parent[0][rootY] = 0;
			parent[0][rootX] = 0;
			parent[1][rootY] = 0;
			parent[1][rootX] = 0;
		}
	}

}
