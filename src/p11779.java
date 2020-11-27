import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11779 {
	public static class Edge implements Comparable<Edge>{
		public int to;
		public int weight;
		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		
		public int compareTo(Edge e) {
			return weight -e.weight;
		}
	}
	public static int n, m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
		}
	}

}
