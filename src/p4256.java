import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p4256 {
	public static class Node{
		public int data;
		public int left;
		public int right;
	}
	
	public static Node[] arr;
	public static int N, root;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());
			arr = new Node[N+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			root = Integer.parseInt(st.nextToken());
			for(int i=1; i<N; i++) {
				
			}
		}
	}

}
