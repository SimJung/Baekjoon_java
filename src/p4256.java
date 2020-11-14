import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p4256 {
	public static class Node{
		public int data;
		public int left;
		public int right;
		
		public Node(int d) {
			data= d;
			left = 0;
			right = 0;
		}
	}
	
	public static Node[] arr;
	public static int[] pre, in;
	public static int N, root, preIdx, inIdx;
	public static boolean[] visit;
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());
			arr = new Node[N+1];
			pre = new int[N];
			in = new int[N];
			visit = new boolean[N+1];
			preIdx = 0;
			inIdx = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				pre[i] = Integer.parseInt(st.nextToken());
			}
			
			root = pre[0];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				in[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<=N; i++) {
				arr[i] = new Node(i);
				
			}
			
			
			recur(root);
			
			post(root);
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void recur(int n) {
		visit[n] = true;
		preIdx++;
		
		if(inIdx < N && visit[in[inIdx]]) {
			inIdx++;
		}else if(preIdx < N){
			arr[n].left = pre[preIdx];
			recur(pre[preIdx]);
		}
		
		if(inIdx < N && visit[in[inIdx]]) {
			inIdx++;
		}else if(preIdx < N){
			arr[n].right = pre[preIdx];
			recur(pre[preIdx]);
		}
	}
	
	public static void post(int n) throws IOException{
		if(arr[n].left != 0) {
			post(arr[n].left);
		}
		
		if(arr[n].right != 0) {
			post(arr[n].right);
		}
		
		bw.write(arr[n].data+" ");
	}
}
