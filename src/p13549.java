import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p13549 {
	public static int N, K, T;
	public static Queue<Integer> tq = new LinkedList<>();
	public static Queue<Integer> mq = new LinkedList<>();
	public static boolean visit[] = new boolean[100001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		mq.offer(N);
		
		while(!mq.isEmpty() || !tq.isEmpty()) {
			
			while(!mq.isEmpty()) {
				
				int now = mq.poll();
				tq.offer(now);
				
				if(now == K) {
					System.out.println(T);
					return ;
				}
				
				int tp = now*2;
				while(tp <= 100000 && tp != 0) {
					if(visit[tp]) {
						tp *= 2;
						continue;
					}
					
					 visit[tp] = true;
					 tq.offer(tp);
					 if(tp == K) {
							System.out.println(T);
							return ;
						}
					 
					 tp *= 2;
				}
			}
			
			while(!tq.isEmpty()) {
				
				int now = tq.poll();
				if(now == K) {
					System.out.println(T);
					return ;
				}
				
				if(now-1 >= 0 && !visit[now-1]) {
					if(now-1 == K) {
						System.out.println(T+1);
						return ;
					}
					
					visit[now-1] = true;
					mq.offer(now-1);
				}
				
				if(now+1 <= 100000 && !visit[now+1]) {
					if(now+1 == K) {
						System.out.println(T+1);
						return ;
					}
					
					visit[now+1] = true;
					mq.offer(now+1);
				}
				
			}
			
			
			T++;
		}
		
		System.out.println(T);
	}
}
