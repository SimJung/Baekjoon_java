import java.util.PriorityQueue;
import java.util.Scanner;

public class p17140 {
	public static class Info implements Comparable<Info>{
		public int num;
		public int cnt;
		public Info(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
		
		public int compareTo(Info i) {
			if(cnt == i.cnt) return num - i.num;
			return cnt - i.cnt;
		}
		
	}
	public static int R, C, K, nowR =3, nowC = 3, T;
	public static int arr[][] = new int[101][101];
	public static Info infoList[] = new Info[101];
	public static PriorityQueue<Info> pq = new PriorityQueue<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		K = sc.nextInt();
		
		for(int i=0; i<=100; i++) {
			infoList[i] = new Info(i, 0);
		}
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		while(arr[R-1][C-1] != K && T++ < 100) {
			initInfoList();
			pq.clear();
			
			if(nowR >= nowC) {
				func(true);
			}else {
				func(false);
			}
			
			/*
			System.out.println("T : " + T);
			show();
			System.out.println();
			*/
		}
		
		if(T > 100) System.out.println("-1");
		else System.out.println(T);
		
	}
	
	public static void func(boolean isR) {
		int toI, toJ;
		if(isR) {
			toI = nowR;
			toJ = nowC;
			nowC = 0;
		}else {
			toI = nowC;
			toJ = nowR;
			nowR = 0;
		}
		for(int i=0; i<toI; i++) {
			initInfoList();
			for(int j=0; j<toJ; j++) {
				int temp = 0;
				
				if(isR) {
					temp = arr[i][j];
					arr[i][j] = 0;
				}else {
					temp = arr[j][i];
					arr[j][i] = 0;
				}
				
				infoList[temp].cnt++;
			}
			
			for(int j=1; j<=100; j++) {
				if(infoList[j].cnt != 0) pq.offer(infoList[j]);
			}
			
			int startIdx = 0;
			while(!pq.isEmpty()) {
				if(isR) {
					arr[i][startIdx++] = pq.peek().num;
					arr[i][startIdx++] = pq.peek().cnt;
				}else {
					arr[startIdx++][i] = pq.peek().num;
					arr[startIdx++][i] = pq.peek().cnt;
				}
				pq.poll();
			}
			
			if(isR) {
				nowC = (nowC < startIdx ? startIdx : nowC);
			}else {
				nowR = (nowR < startIdx ? startIdx : nowR);
			}
		}
	}
	
	public static void initInfoList() {
		for(int i=1; i<=100; i++) {
			infoList[i].cnt = 0;
			infoList[i].num = i;
		}
	}
	
	public static void show() {
		for(int i=0; i<nowR; i++) {
			for(int j=0; j<nowC; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
