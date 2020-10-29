import java.util.ArrayList;
import java.util.Scanner;

public class p3190 {
	public static class Info{
		public int i;
		public int j;
		public Info(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
	}
	public static int N, K, L, D, T;
	public static ArrayList<Info> snake = new ArrayList<>();
	public static ArrayList<Info> apple = new ArrayList<>();
	public static ArrayList<Info> time = new ArrayList<>();
	public static int delta[][] = {
			{0, 1},
			{1, 0},
			{0, -1},
			{-1, 0}
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		for(int i=0; i<K; i++) {
			int l = sc.nextInt();
			int c = sc.nextInt();
			apple.add(new Info(l, c));
		}
		
		L = sc.nextInt();
		for(int i=0; i<L; i++) {
			int s = sc.nextInt();
			int r = (sc.next().charAt(0) == 'D' ? 1 : -1);
			time.add(new Info(s, r));
		}
		
		snake.add(new Info(1, 1));
		
		int prevI=0, prevJ=0, nowI=0, nowJ=0, slen=0;
		boolean chk = true;
		while(chk) {
			T++;
			slen = snake.size();
			prevI = snake.get(0).i;
			prevJ = snake.get(0).j;
			snake.get(0).i += delta[D][0];
			snake.get(0).j += delta[D][1];
			nowI = snake.get(0).i;
			nowJ = snake.get(0).j;
			
			
			if(nowI == 0 || nowI == N+1 || nowJ == 0 || nowJ == N+1) break;
		
			for(int i=0; i<apple.size(); i++) {
				if(nowI == apple.get(i).i && nowJ == apple.get(i).j) {
					apple.remove(i);
					snake.add(new Info(snake.get(slen-1).i, snake.get(slen-1).j));
					break;
				}
			}
			
			for(int i=1; i<slen; i++) {
				nowI = snake.get(i).i;
				nowJ = snake.get(i).j;
				
				if(snake.get(0).i == nowI && snake.get(0).j == nowJ) {
					chk = false;
					break;
				}
				
				snake.get(i).i = prevI;
				snake.get(i).j = prevJ;
				
				prevI = nowI;
				prevJ = nowJ;
			}
			
			if(!time.isEmpty() && T == time.get(0).i) {
				D += time.get(0).j;
				if(D == -1) D=3;
				else if(D == 4) D=0;
				time.remove(0);
			}
		}
		System.out.println(T);
	}

}
