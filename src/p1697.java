
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class p1697 {
	static Queue<Integer> q = new LinkedList<>();
	static int[] arr;
	static boolean[] visit;
	static int N, K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		arr = new int[100001];
		visit = new boolean[100001];
		
		visit[N] = true;
		q.offer(N);
		
		while(!q.isEmpty()) {
			int nowPos = q.poll();
			
			if(nowPos+1 <= 100000 && !visit[nowPos+1]) {
				q.offer(nowPos+1);
				arr[nowPos+1] = arr[nowPos]+1;
				visit[nowPos+1] = true;
			}
			
			if(nowPos-1 >= 0 && !visit[nowPos-1]) {
				q.offer(nowPos-1);
				arr[nowPos-1] = arr[nowPos]+1;
				visit[nowPos-1] = true;
			}
			
			if(nowPos*2 <= 100000 && !visit[nowPos*2]) {
				q.offer(nowPos*2);
				arr[nowPos*2] = arr[nowPos]+1;
				visit[nowPos*2] = true;
			}
			
			if(nowPos == K)
			{
				System.out.println(arr[nowPos]);
				return;
			}
		}
	}

}
