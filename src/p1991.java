import java.util.Scanner;

public class p1991 {
	public static int N;
	public static class Node{
		public char data;
		public char left;
		public char right;
	}
	
	public static Node[] arr;
	public static StringBuilder pre = new StringBuilder();
	public static StringBuilder in = new StringBuilder();
	public static StringBuilder post = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new Node[N];
		for(int i = 0; i<N; i++) {
			char now = sc.next().charAt(0);
			int idx = now - 'A';
			arr[idx] = new Node();
			
			arr[idx].data = now;
			arr[idx].left = sc.next().charAt(0);
			arr[idx].right = sc.next().charAt(0);
		}
		
		recur(0);
		System.out.println(pre.toString()+"\n"+in.toString()+"\n"+post.toString());
	}
	
	// 0 : pre, 1 : in, 2 : post
	public static void recur(int idx) {
		pre.append(arr[idx].data);
		if(arr[idx].left != '.') recur(arr[idx].left - 'A');
		in.append(arr[idx].data);
		if(arr[idx].right != '.') recur(arr[idx].right - 'A');
		post.append(arr[idx].data);
	}

}
