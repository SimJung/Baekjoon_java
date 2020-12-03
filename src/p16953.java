import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p16953 {
	public static final long MAXVAL = 1000000001;
	
	public static class Info{
		public long num;
		public int cnt;
		public Info(long num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long A = sc.nextLong(), B = sc.nextLong();
		
		Queue<Info> q = new LinkedList<>();
		//HashSet<Integer> set = new HashSet<>();
		
		q.offer(new Info(A, 1));
		//set.add((int)A);
		
		while(!q.isEmpty()) {
			Info now = q.poll();
			
			if(now.num == B) {
				System.out.println(now.cnt);
				return ;
			}
			
			long newNum = now.num * 2;
			if(newNum < MAXVAL){
				q.offer(new Info(newNum, now.cnt+1));
			}
			
			newNum = now.num * 10 + 1;
			if(newNum < MAXVAL){
				q.offer(new Info(newNum, now.cnt+1));
			}
			
		}
		
		System.out.println("-1");
	}

}
