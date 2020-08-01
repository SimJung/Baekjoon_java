package boj_java;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p10866 {
	static int[] arr = new int[20001];
	static int front = 10000, back = 10000;
	public static void main(String[] args) throws IOException{
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			switch(st.nextToken()) {
			case "push_front":
				push_front(Integer.parseInt(st.nextToken()));
				break;
				
			case "push_back":
				push_back(Integer.parseInt(st.nextToken()));
				break;
				
			case "pop_front":
				bw.write(pop_front() + "\n");
				break;
				
			case "pop_back":
				bw.write(pop_back() + "\n");
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
			
			//bw.write("Front : " + front + "\nBack : " + back+ "\n\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static int empty() {
		if(back == front) return 1;
		return 0;
	}
	
	static void push_back(int a) {
		arr[back++] = a;
	}
	
	static void push_front(int a) {
		arr[--front] = a;
	}
	
	static int pop_back() {
		if(empty() == 1) return -1;
		return arr[--back];
	}
	
	static int pop_front() {
		if(empty() == 1) return -1;
		return arr[front++];
	}
	
	static int size() {
		return back - front;
	}
	
	static int frontf() {
		if(empty() == 1) return -1;
		return arr[front];
	}
	
	static int backf() {
		if(empty() == 1) return -1;
		return arr[back-1];
	}
}
