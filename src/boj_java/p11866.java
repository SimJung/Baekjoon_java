package boj_java;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class p11866 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt();
		Queue<Integer> q= new LinkedList<Integer>();
		Queue<Integer> ans= new LinkedList<Integer>();
		
		for(int i=1; i<=n; i++) {
			q.offer(i);
		}
		
		while(!q.isEmpty()) {
			for(int i=0; i<k-1; i++) {
				q.offer(q.poll());
			}
			ans.offer(q.poll());
		}
		
		System.out.print("<");
		int sz = ans.size()-1;
		for(int i=0; i<sz; i++)
			System.out.print(ans.poll()+", ");
		System.out.println(ans.poll() + ">");
	}

}
