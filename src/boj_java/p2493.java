package boj_java;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;
public class p2493 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		Stack<int[]> s = new Stack<int[]>();
		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int arr[] = new int[N];
		int ans[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=N-1; i>0; i--) {
			s.push(new int[] {arr[i], i});
			while(!s.empty() && s.peek()[0] < arr[i-1]) {
				ans[s.peek()[1]] = i;
				s.pop();
			}
		}
		
		for(int i=0; i<N; i++) {
			bw.write(ans[i] + " ");
		}
		bw.write("\n");
		bw.flush();
		bw.close();
	}
}
