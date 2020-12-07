import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p13549 {
	public static int N, K, T;
	public static Queue<Integer> q = new LinkedList<>();
	public static boolean visit[] = new boolean[100001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		
		visit[N] = true;
		q.offer(N);
		
		while(true) {
			int sz = q.size();
			
			for(int i=0; i<sz; i++) {
				int now = q.poll();
				if(now == K) {
					System.out.println(T);
					return ;
				}
				
				int res = tp(now * 2);
				if(res == -1) {
					return ;
				}else {
					sz += res;
				}
				
				
				if(now - 1 >= 0 && !visit[now-1]) {
					if(now-1 == K) {
						System.out.println(T+1);
						return ;
					}
					visit[now-1] = true;
					q.offer(now-1);
				}
				
				if(now + 1 <= 100000 && !visit[now+1]) {
					if(now+1 == K) {
						System.out.println(T+1);
						return ;
					}
					visit[now+1] = true;
					q.offer(now+1);
				}
			}
			
			T++;
		}
	}

	public static int tp(int t) {
		if(t > 100000 || t == 0) return 0;
		if(!visit[t]) {
			visit[t] = true;
			q.offer(t);
			if(t == K) {
				System.out.println(T);
				return -1;
			}
			return tp(t*2)+1;
		}
		return tp(t*2);
	}
}
