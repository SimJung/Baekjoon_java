
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class p17135 {
	static class Enemy{
		public int i, j;
		Enemy(int a, int b){
			i = a;
			j = b;
		}
	}
	
	static class EnemyDist implements Comparable<EnemyDist>{
		public int d;
		Enemy e;
		
		EnemyDist(int a, Enemy b){
			d = a;
			e = b;
		}
		
		public int compareTo(EnemyDist ed) {
			if(this.d - ed.d != 0)
				return this.d - ed.d;
			
			return this.e.j - ed.e.j;
		}
	}
	
	static class Archer{
		public int i, j;
		
		public ArrayList<EnemyDist> edList;
		
		Archer(int a, int b){
			i = a;
			j = b;
			edList = new ArrayList<>();
		}
	}
	static int N, M, D, ans;
	static ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	static ArrayList<Archer> archerList = new ArrayList<>();
	static Queue<int[]> archerPosition = new LinkedList<>();
	static boolean enemy[][];
	static int[] archerX = new int[3];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		
		enemy = new boolean[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(sc.nextInt() == 1) {
					enemyList.add(new Enemy(i, j));
					enemy[i][j] = true;
				}
			}
		}
		
		make_position(0, 0);
		
		while(!archerPosition.isEmpty())
		{
			int temp = 0;
			boolean enemyMap[][] = new boolean[N][];
			ArrayList<Enemy> tempEnemyList = new ArrayList<>();
			tempEnemyList.addAll(enemyList);
			for(int i=0; i<N; i++) {
				enemyMap[i] = Arrays.copyOf(enemy[i], M);
			}
			for(int archer_i=N; archer_i>0; archer_i--) {
				for(int i=0; i<3; i++) {
					archerList.add(new Archer(archer_i, archerPosition.peek()[i]));
				}
				
				ArrayList<int[]> hs = new ArrayList<>();
				ArrayList<Enemy> de = new ArrayList<>();
				for(int i=0; i<3; i++) {
					getEnemyList(archerList.get(i), tempEnemyList);
					Collections.sort(archerList.get(i).edList);
					if(!archerList.get(i).edList.isEmpty()) {
						int ei = archerList.get(i).edList.get(0).e.i;
						int ej = archerList.get(i).edList.get(0).e.j;
						if(enemyMap[ei][ej]) {
							de.add(archerList.get(i).edList.get(0).e);
							hs.add(new int[] {ei, ej});
						}
					}
					
					archerList.get(i).edList.clear();
				}
				
				for(int[] e : hs) {
					if(enemyMap[e[0]][e[1]]) {
						enemyMap[e[0]][e[1]] = false;
						temp++;
					}
				}
				
				for(Enemy e : de) {
					tempEnemyList.remove(e);
				}
				
				
				archerList.clear();
			}
			archerPosition.poll();
			if(ans < temp)
				ans = temp;
		}
		
		System.out.println(ans);
	}
	
	public static void make_position(int cnt, int idx) {
		if(cnt == 3) {
			int[] temp = Arrays.copyOf(archerX, archerX.length);
			archerPosition.add(temp);
			return ;
		}
		
		for(int i=idx; i<M; i++) {
			archerX[cnt] = i;
			make_position(cnt+1, i+1);
		}
	}
	
	public static void getEnemyList(Archer a, ArrayList<Enemy> list) {
		for(Enemy e : list) {
			int dist_Enemy = getDist(a, e);
			if(dist_Enemy <= D && a.i > e.i) {
				a.edList.add(new EnemyDist(dist_Enemy, e));
			}
		}
	}
	
	public static int getDist(Archer a, Enemy e) {
		return Math.abs(a.i - e.i) + Math.abs(a.j - e.j);
	}
	
}
