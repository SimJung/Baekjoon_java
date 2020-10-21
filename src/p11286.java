import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class p11286 {
	public static class A implements Comparable<A>{
		public int num;

		public A(int num) {
			super();
			this.num = num;
		}
		
		public int compareTo(A a) {
			if(Math.abs(num) != Math.abs(a.num))
				return Math.abs(num) - Math.abs(a.num);
			else
				return num - a.num;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<A> pq = new PriorityQueue<>();
		while(N-- > 0) {
			int x = Integer.parseInt(br.readLine());
			
			if(x == 0) {
				if(pq.isEmpty()) bw.write("0\n");
				else bw.write(Integer.toString(pq.poll().num)+"\n");
			}else {
				pq.offer(new A(x));
			}
		}
		
		bw.flush();
		bw.close();
	}

}
