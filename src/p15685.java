import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p15685 {
	public static class Info{
		public int x;
		public int y;
		public Info(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static int N;
	public static boolean visit[][];
	public static ArrayList<Info> list = new ArrayList<>();
	public static int delta[][] = {
			{0, 1},
			{-1, 0},
			{0, -1},
			{1, 0}
	};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		visit = new boolean[101][101];
		
		for(int i=0; i<N; i++) {
			list.clear();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			Info info = new Info(x, y);
			int d = Integer.parseInt(st.nextToken()), cnt = Integer.parseInt(st.nextToken());
			
			visit[info.y][info.x] = true;
			int ny = y + delta[d][0];
			int nx = x + delta[d][1];
			
			visit[ny][nx] = true;
			
			list.add(info);
			list.add(new Info(nx, ny));
			
			for(int j=0; j<cnt; j++) {
				int sz = list.size();
				Info spot = list.get(sz-1);
				for(int k=sz-1; k>=0; k--) {
					Info newInfo = rotate(list.get(k), spot);
					visit[newInfo.y][newInfo.x] = true;
					list.add(newInfo);
				}
			}
		}
		
		int ans = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(visit[i][j] && visit[i+1][j] && visit[i][j+1] && visit[i+1][j+1]) ans++;
			}
		}
		
		System.out.println(ans);
	}
	
	public static Info rotate(Info src, Info spot) {
		Info ret = new Info(spot.x, spot.y);
		int dx = src.x - spot.x;
		int dy = src.y - spot.y;
		
		int temp = dy;
		dy = dx;
		dx = temp * -1;
		
		ret.x += dx; ret.y += dy;
		return ret;
	}

}
