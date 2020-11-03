import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p5644 {
	public static class Info{
		public int i;
		public int j;
		public Info(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
	
	public static class BC{
		public Info pos;
		public int area;
		public int p;
		public BC(Info pos, int area, int p) {
			super();
			this.pos = pos;
			this.area = area;
			this.p = p;
		}
		
		public boolean canUse(Info p) {
			return (area >= (Math.abs(pos.i - p.i) + Math.abs(pos.j - p.j)));
		}
	}
	
	public static class Pinfo implements Comparable<Pinfo>{
		public int n;

		public Pinfo(int n) {
			super();
			this.n = n;
		}
		
		public int compareTo(Pinfo i) {
			return bcList[i.n].p - bcList[n].p;
		}
	}
	public static int delta[][] = {
			{0, 0},
			{-1, 0},
			{0, 1},
			{1, 0},
			{0, -1}
	};
	static BC[] bcList;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int ans = 0;
			int M = Integer.parseInt(st.nextToken()), A = Integer.parseInt(st.nextToken());
			bcList = new BC[A];
			char[] aMove = br.readLine().toCharArray();
			char[] bMove = br.readLine().toCharArray();
			Info a = new Info(1, 1);
			Info b = new Info(10, 10);
			
			for(int i=0; i<A; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				bcList[i] = new BC(new Info(y, x), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			int canUse[] = new int[A];
			PriorityQueue<Pinfo> apq = new PriorityQueue<>();
			PriorityQueue<Pinfo> bpq = new PriorityQueue<>();
			for(int i=0; i<M; i++) {
				
				apq.clear();
				bpq.clear();
				
				Arrays.fill(canUse, 0);
				for(int j=0; j<A; j++) {
					if(bcList[j].canUse(a)) {
						canUse[j]++;
						apq.offer(new Pinfo(j));
					}
					if(bcList[j].canUse(b)) {
						canUse[j]++;
						bpq.offer(new Pinfo(j));
					}
				}
				
				if(apq.isEmpty() && bpq.isEmpty()) {
					
				}else if(apq.isEmpty()) {
					ans += bcList[bpq.poll().n].p;
				}else if(bpq.isEmpty()) {
					ans += bcList[apq.poll().n].p;
				}else if(!apq.isEmpty() && canUse[apq.peek().n] == 1) {
					ans += bcList[apq.peek().n].p;
					if(!bpq.isEmpty()) ans += bcList[bpq.peek().n].p;
				}else if(!bpq.isEmpty() && canUse[bpq.peek().n] == 1) {
					ans += bcList[bpq.peek().n].p;
					if(!apq.isEmpty()) ans += bcList[apq.peek().n].p;
				}else if(apq.size() == 1 && bpq.size() == 1) {
					ans += bcList[apq.peek().n].p;
					
				}else if(apq.size() == 1 || bpq.size() == 1) {
					if(apq.size() == 1) {
						ans += bcList[apq.peek().n].p;
						bpq.poll();
						ans += bcList[bpq.peek().n].p;
					}else {
						ans += bcList[bpq.peek().n].p;
						apq.poll();
						ans += bcList[apq.peek().n].p;
					}
				}else {
					ans += bcList[apq.poll().n].p;
					bpq.poll();
					
					int tempA = bcList[apq.poll().n].p;
					int tempB = bcList[bpq.poll().n].p;
					
					if(tempA > tempB) ans += tempA;
					else ans += tempB;
				}
				
				a.i += delta[aMove[i*2] - '0'][0];
				a.j += delta[aMove[i*2] - '0'][1];
				
				b.i += delta[bMove[i*2] - '0'][0];
				b.j += delta[bMove[i*2] - '0'][1];
			}
			apq.clear();
			bpq.clear();
			
			for(int j=0; j<A; j++) {
				if(bcList[j].canUse(a)) {
					canUse[j]++;
					apq.offer(new Pinfo(j));
				}
				if(bcList[j].canUse(b)) {
					canUse[j]++;
					bpq.offer(new Pinfo(j));
				}
			}
			
			if(apq.isEmpty() && bpq.isEmpty()) {
			}else if(apq.isEmpty()) {
				ans += bcList[bpq.poll().n].p;
			}else if(bpq.isEmpty()) {
				ans += bcList[apq.poll().n].p;
			}else if(!apq.isEmpty() && canUse[apq.peek().n] == 1) {
				ans += bcList[apq.peek().n].p;
				if(!bpq.isEmpty()) ans += bcList[bpq.peek().n].p;
			}else if(!bpq.isEmpty() && canUse[bpq.peek().n] == 1) {
				ans += bcList[bpq.peek().n].p;
				if(!apq.isEmpty()) ans += bcList[apq.peek().n].p;
			}else if(apq.size() == 1 && bpq.size() == 1) {
				ans += bcList[apq.peek().n].p;
				
			}else if(apq.size() == 1 || bpq.size() == 1) {
				if(apq.size() == 1) {
					ans += bcList[apq.peek().n].p;
					bpq.poll();
					ans += bcList[bpq.peek().n].p;
				}else {
					ans += bcList[bpq.peek().n].p;
					apq.poll();
					ans += bcList[apq.peek().n].p;
				}
			}else {
				ans += bcList[apq.poll().n].p;
				bpq.poll();
				
				int tempA = bcList[apq.poll().n].p;
				int tempB = bcList[bpq.poll().n].p;
				
				if(tempA > tempB) ans += tempA;
				else ans += tempB;
			}
			
			
			
			System.out.println("#"+tc+" "+ans);
		}
		
		
	}

}
