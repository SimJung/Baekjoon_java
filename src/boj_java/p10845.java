package boj_java;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p10845 {
	static int[] arr = new int[10001];
	static int front = 0, back = -1;
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
				
			case "pop":
				bw.write(pop() + "\n");
				break;
				
			case "size":
				bw.write(size() + "\n");
				break;
				
			case "empty":
				bw.write(empty() + "\n");
				break;
				
			case "front":
				bw.write(frontf() + "\n");
				break;
				
			case "back":
				bw.write(backf() + "\n");
				break;
			}
		}
		bw.flush();
		bw.close();
	}
	
	static int empty() {
		if(back == front-1) return 1;
		return 0;
	}
	
	static void push(int a) {
		arr[++back] = a;
	}
	
	static int pop() {
		if(empty() == 1) return -1;
		return arr[front++];
	}
	static int size() {
		return back - front + 1;
	}
	
	static int frontf() {
		if(empty() == 1) return -1;
		return arr[front];
	}
	
	static int backf() {
		if(empty() == 1) return -1;
		return arr[back];
	}
}
