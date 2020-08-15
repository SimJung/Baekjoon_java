
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p4179 {
	static int dir[][] = {
			{-1, 0},
			{1, 0},
			{0, 1},
			{0, -1}
	};
	
	static Queue<int[]> jPos = new LinkedList<int[]>();
	static Queue<int[]> firePos = new LinkedList<int[]>();
	static char[][] map;
	static int[][] times;
	static int r, c;
	static int TimeOver = 10000001;
	
	public static void main(String[] args) throws IOException{
		int ans = TimeOver;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(bf.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		times = new int[r][c];
		String s;
		for(int i=0; i<r; i++) {
			s = bf.readLine();
			map[i] = s.toCharArray();
			if(s.indexOf('J') != -1) {
				jPos.offer(new int[] {i, s.indexOf('J')});
			}
			if(s.indexOf('F') != -1) {
				for(int j=0; j<c; j++) {
					if(map[i][j] == 'F') {
						firePos.offer(new int[] {i, j});
						times[i][j] = TimeOver;
					}
				}
			}
		}
		/*
		while(!jPos.isEmpty()) {
			
			int nowi = jPos.peek()[0];
			int nowj = jPos.peek()[1];
			jPos.poll();
			
			for(int i=0; i<4; i++) {
				int ni = nowi + dir[i][0];
				int nj = nowj + dir[i][1];
				if(canJGo(ni, nj)) {
					map[ni][nj] = 'J';
					times[ni][nj] = times[nowi][nowj]+1;
				}
			}
			
			int sz = firePos.size();
			for(int i=0; i<sz; i++) {
				int temp[] = firePos.peek();
				for(int j=0; j<4; j++) {
					int ni = temp[0]+ dir[j][0];
					int nj = temp[1]+ dir[j][1];
					if(canFGo(ni, nj)) {
						map[ni][nj] = 'F';
						times[ni][nj] = TimeOver;
					}
				}
				firePos.poll();
			}
			
			for(int i=0; i<4; i++) {
				
				int ni = nowi + dir[i][0];
				int nj = nowj + dir[i][1];
				if(isJAlive(ni, nj)) {
					if(ni == 0 || ni == r-1 || nj == 0 || nj == c-1) {
						System.out.println(times[ni][nj]+1);
						return;
					}
					jPos.offer(new int[] {ni, nj});
				}
			}
			
			
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					
				}
			}
			
		}
		System.out.println("IMPOSSIBLE");
		*/
		
		Queue<int[]> nowJpos = new LinkedList<>();
		while(true) {
			int nowJposSz = jPos.size();
			nowJpos.clear();
			for(int i=0; i<nowJposSz; i++) {
				for(int j=0; j<4; j++) {
					int ni = dir[j][0]+jPos.peek()[0];
					int nj = dir[j][1]+jPos.peek()[1];
					if(canJGo(ni, nj)) {
						nowJpos.offer(new int[] {ni, nj});
						map[ni][nj] = 'J';
						times[ni][nj] = times[jPos.peek()[0]][jPos.peek()[1]]+1;
					}else if(canJEscape(ni, nj)) {
						System.out.println(times[jPos.peek()[0]][jPos.peek()[1]]+1);
						return ;
					}
				}
				jPos.poll();
			}
			
			int nowFireSz = firePos.size();
			for(int i=0; i<nowFireSz; i++) {
				int temp[] = firePos.peek();
				for(int j=0; j<4; j++) {
					int ni = temp[0]+ dir[j][0];
					int nj = temp[1]+ dir[j][1];
					if(canFGo(ni, nj)) {
						map[ni][nj] = 'F';
						times[ni][nj] = TimeOver;
						firePos.offer(new int[] {ni, nj});
					}
				}
				firePos.poll();
			}
			
			while(!nowJpos.isEmpty()) {
				int ni = nowJpos.peek()[0];
				int nj = nowJpos.peek()[1];
				if(isJAlive(ni, nj)) {
					jPos.offer(new int[] {ni, nj});
				}
				nowJpos.poll();
			}
			
			if(jPos.isEmpty()) {
				System.out.println("IMPOSSIBLE");
				return ;
			}
		}
	}
	
	static boolean canJGo(int i, int j) {
		if(i < 0 || i >= r || j < 0 || j >= c || map[i][j] != '.')
			return false;
		return true;
	}
	
	static boolean canFGo(int i, int j) {
		if(i < 0 || i >= r || j < 0 || j >= c || map[i][j] == 'F' || map[i][j] == '#')
			return false;
		return true;
	}
	
	static boolean isJAlive(int i, int j) {
		if(i < 0 || i >= r || j < 0 || j >= c || map[i][j] != 'J')
			return false;
		return true;
	}
	
	static boolean canJEscape(int i, int j) {
		if(i < 0 || i >= r || j < 0 || j >= c)
			return true;
		return false;
	}
}
