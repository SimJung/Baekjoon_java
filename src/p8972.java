import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p8972 {
	static class Crazy{
		public int i;
		public int j;
		public Crazy(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
	public static int R, C, nowI, nowJ;
	public static ArrayList<Crazy> crazy[][];
	public static char arr[][];
	
	public static int delta[][] = {
			{0, 0},
			{1, -1},
			{1, 0},
			{1, 1},
			{0, -1},
			{0, 0},
			{0, 1},
			{-1, -1},
			{-1, 0},
			{-1, 1}
	};
	
	public static ArrayList<Crazy> crazyList = new ArrayList<>();
	public static ArrayList<int[]> boomCrazy = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		crazy = new ArrayList[R][C];
		arr = new char[R][];
		for(int i=0; i<R; i++) {
			arr[i] = sc.next().toCharArray();
			for(int j=0; j<C; j++) {
				crazy[i][j] = new ArrayList<>();
				if(arr[i][j] == 'R') {
					Crazy c = new Crazy(i, j);
					crazyList.add(c);
					crazy[i][j].add(c);
					boomCrazy.add(new int[] {i, j});
				}else if(arr[i][j] == 'I') {
					nowI = i;
					nowJ = j;
				}
			}
		}
		
		String cmdlist = sc.next();
		for(int i=0; i<cmdlist.length(); i++) {
			arr[nowI][nowJ] = '.';
			nowI += delta[cmdlist.charAt(i) - '0'][0];
			nowJ += delta[cmdlist.charAt(i) - '0'][1];
			
			if(crazy[nowI][nowJ].size() > 0) {
				System.out.println("kraj "+(i+1));
				return ;
			}
			
			arr[nowI][nowJ] = 'I';
			
			int sz = boomCrazy.size();
			for(int j=0; j<sz; j++) {
				int tI = boomCrazy.get(0)[0];
				int tJ = boomCrazy.get(0)[1];
				boomCrazy.remove(0);
				int dir = 0;
				for(int k=1; k<=9; k++) {
					if(tI+delta[k][0] < 0 || tI+delta[k][0] >= R || tJ+delta[k][1] < 0 || tJ+delta[k][1] >= C) continue;
					if(Math.abs(nowI - (tI + delta[k][0])) + Math.abs(nowJ - (tJ + delta[k][1])) < Math.abs(nowI - (tI + delta[dir][0])) + Math.abs(nowJ - (tJ + delta[dir][1]))) {
						dir = k;
					}
				}
				
				if(crazy[tI][tJ].size() == 0) continue;
				crazy[tI][tJ].get(0).i += delta[dir][0];
				crazy[tI][tJ].get(0).j += delta[dir][1];
				if(arr[tI + delta[dir][0]][tJ + delta[dir][1]] == 'I') {
					System.out.println("kraj "+(i+1));
					return ;
				}
				crazy[tI+delta[dir][0]][tJ+delta[dir][1]].add(crazy[tI][tJ].get(0));
				crazy[tI][tJ].clear();
				arr[tI][tJ] = '.';
				arr[tI+delta[dir][0]][tJ+delta[dir][1]] = 'R';
				boomCrazy.add(new int[] {tI + delta[dir][0], tJ+delta[dir][1]});
			}
			
			for(int j=0; j<boomCrazy.size(); j++) {
				int tI = boomCrazy.get(j)[0];
				int tJ = boomCrazy.get(j)[1];
				if(crazy[tI][tJ].size()>1) {
					for(int k=0; k<crazy[tI][tJ].size(); k++) {
						Crazy c = crazy[tI][tJ].get(k);
						crazy[tI][tJ].remove(k--);
						crazyList.remove(c);
					}
					arr[tI][tJ] = '.';
				}else if(crazy[tI][tJ].size() == 0) {
					boomCrazy.remove(j--);
				}else {
					arr[tI][tJ] = 'R';
				}
			}
			
			
			for(int j=0; j<R; j++) {
				for(int k=0; k<C; k++) {
					System.out.print(arr[j][k]);
				}
				System.out.println();
			}
			System.out.println();
			
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

}
