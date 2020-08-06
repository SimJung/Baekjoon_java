package boj_java;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
public class p10816 {
	static Map<Integer, Integer> arr;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n, m, idx = 0;
		n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		arr = new HashMap<Integer, Integer>();
		for(int i=0; i<n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(arr.containsKey(temp)) arr.replace(temp, arr.get(temp)+1);
			else arr.put(temp, 1);
		}
		m = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<m; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(arr.containsKey(temp))
				bw.write(arr.get(temp) + " ");
			else
				bw.write("0 ");
		}
		bw.write("\n");
		bw.flush();
		bw.close();
	}
}
