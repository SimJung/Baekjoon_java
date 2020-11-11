import java.util.Scanner;

public class p1991 {
	public static int N;
	public static class Node{
		public char data;
		public char left;
		public char right;
	}
	
	public static Node[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new Node[N];
		for(int i = 0; i<N; i++) {
			char now = sc.next().charAt(0);
			arr[now - 'A'] = new Node();
			
			arr[now - 'A'].data = now;
			arr[now - 'A'].left = sc.next().charAt(0);
			arr[now - 'A'].right = sc.next().charAt(0);
		}
		
		recur(0, 0);
		System.out.println();
		recur(0, 1);
		System.out.println();
		recur(0, 2);
		System.out.println();
	}
	
	// 0 : pre, 1 : in, 2 : post
	public static void recur(int idx, int flag) {
		if(flag == 0) System.out.print(arr[idx].data);
		if(arr[idx].left != '.') recur(arr[idx].left - 'A', flag);
		if(flag == 1) System.out.print(arr[idx].data);
		if(arr[idx].right != '.') recur(arr[idx].right - 'A', flag);
		if(flag == 2) System.out.print(arr[idx].data);
	}

}
