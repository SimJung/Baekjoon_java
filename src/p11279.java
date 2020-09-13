import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class p11279 {
	static class Big implements Comparable<Big>{
		public int no;
		public Big(int n) {
			no = n;
		}
		public int compareTo(Big b) {
			return b.no - no;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		PriorityQueue<Big> pq = new PriorityQueue<>();
		while(T-- > 0) {
			int temp = Integer.parseInt(br.readLine());
			if(temp == 0) {
				bw.write((pq.isEmpty() ? 0 : pq.poll().no)+"\n");
			}else {
				pq.add(new Big(temp));
			}
		}
		bw.flush();
		bw.close();
	}

}
