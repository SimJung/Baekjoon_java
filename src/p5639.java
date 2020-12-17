import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class p5639 {
	public static class Node {
		public int data;
		public int left;
		public int right;
		
	}
	
	public static int root = 0, idx = 0;
	public static Node[] arr = new Node[1000000];
	public static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			if(str == null || str.equals("")) break;
			int n = Integer.parseInt(str);
			arr[n] = new Node();
			arr[n].data = n;
			
			list.add(n);
			
			if(list.size() == 9) break;
		}
		
		root = list.get(0);
		pre(root);
		post(root);
	}
	
	public static void pre(int n) {
		idx++;
		if(idx < list.size() && n > list.get(idx)) {
			arr[n].left = list.get(idx);
			pre(arr[n].left);
		}
		
		if(idx < list.size() && n < list.get(idx)) {
			arr[n].right = list.get(idx);
			pre(arr[n].right);
		}
	}
	
	public static void post(int n) {
		if(arr[arr[n].left] != null)
			post(arr[n].left);
		
		if(arr[arr[n].right] != null)
			post(arr[n].right);
		
		System.out.println(n);
	}

}
