import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p19637 {
	static int N, M, arr[];
	static HashMap<Integer, String> hm = new HashMap<>();
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String tempStr = st.nextToken();
			arr[i] = Integer.parseInt(st.nextToken());
			if(!hm.containsKey(arr[i]))
				hm.put(arr[i], tempStr);
		}
		
		for(int i=0; i<M; i++) {
			bw.write(hm.get(arr[binary_search(0, N-1, Integer.parseInt(br.readLine()))])+"\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static int binary_search(int left, int right, int val) {
		if(left == N) return N-1;
		else if(left > right) return left;
		int mid = (left + right)/2;
		if(arr[mid] == val) return mid;
		else if(arr[mid] > val) return binary_search(left, mid-1, val);
		else return binary_search(mid+1, right, val);
	}
}
