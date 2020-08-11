
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p10828 {
	static int[] arr = new int[10001];
	static int top = -1;
	public static void main(String[] args) throws IOException{
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			switch(st.nextToken()) {
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;
				
			case "top":
				bw.write(top() + "\n");
				break;
				
			case "pop":
				bw.write(pop() + "\n");
				break;
				
			case "size":
				bw.write(size() + "\n");
				break;
				
			case "empty":
				bw.write(empty() + "\n");
				break;
			}
		}
		bw.flush();
		bw.close();
	}
	
	static int empty() {
		if(top == -1) return 1;
		return 0;
	}
	
	static void push(int a) {
		arr[++top] = a;
	}
	static int top() {
		return (top == -1 ? -1 : arr[top]);
	}
	static int pop() {
		if(empty() == 1) return -1;
		return arr[top--];
	}
	static int size() {
		return top+1;
	}

}
