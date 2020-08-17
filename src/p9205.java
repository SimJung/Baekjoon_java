import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class p9205 {
	public static class Spot{
		public int x, y;
		Spot(int xx, int yy){
			x = xx;
			y = yy;
		}
		
		public boolean canArrive(Spot other) {
			return (Math.abs(other.x - this.x) + Math.abs(other.y - this.y) <= 1000);
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		while(T-- > 0) {
			int N = Integer.parseInt(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine());
			Spot home = new Spot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Spot[] spots = new Spot[N+1];
			boolean visit[] = new boolean[N+1];
			for(int i=0; i<N+1; i++) {
				st = new StringTokenizer(bf.readLine());
				spots[i] = new Spot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			Queue<Spot> q = new LinkedList<>();
			q.offer(home);
			boolean chk = false;
			while(!q.isEmpty()) {
				Spot temp = q.poll();
				for(int i=0; i<N+1; i++) {
					if(temp.canArrive(spots[i]) && !visit[i]) {
						q.offer(spots[i]);
						visit[i] = true;
						
						if(i == N) {
							System.out.println("happy");
							chk = true;
							break;
						}
					}
				}
				if(chk) break;
			}
			if(!chk)
				System.out.println("sad");
			
		}
	}

}
