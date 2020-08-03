package boj_java;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
public class p2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=1; i<=n; i++)
			q.offer(i);
		
		while(q.size() != 1) {
			q.poll();
			if(q.size() == 1)
				break;
			q.offer(q.poll());
		}
		
		System.out.println(q.poll());
	}

}
