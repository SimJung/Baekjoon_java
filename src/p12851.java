import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p12851 {
	public static int N, K, ans, ansCnt;
	public static boolean visit[] = new boolean[100001];
	public static Queue<Integer> q = new LinkedList<>();
	public static Queue<Integer> vq = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
	
		q.offer(N);
		visit[N] = true;
		
		while(true) {
			
			int sz = q.size();
			for(int i=0; i<sz; i++) {
				int temp = q.poll();
				if(temp == K) {
					ansCnt++;
				}else {
					if(temp -1 >= 0 && (!visit[temp-1]) || temp-1 == K) {
						vq.offer(temp-1);
						q.offer(temp-1);
					}
					
					if(temp +1 <= 100000 && (!visit[temp+1]) || temp+1 == K) {
						vq.offer(temp+1);
						q.offer(temp+1);
					}
					
					if(temp *2 <= 100000 && (!visit[temp*2]) || temp*2 == K) {
						vq.offer(temp*2);
						q.offer(temp*2);
					}
				}
			}
			
			while(!vq.isEmpty()) {
				visit[vq.poll()] = true;
			}
			
			if(ansCnt > 0) {
				System.out.println(ans);
				System.out.println(ansCnt);
				return ;
			}
			
			if(q.isEmpty()) {
				System.out.println(0);
				System.out.println(0);
				return ;
			}
			ans++;
		}
	}
}
