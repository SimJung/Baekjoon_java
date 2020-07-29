package boj_java;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class p10952 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s;
		StringTokenizer st;
		int a, b;
		while(true) {
			s = bf.readLine();
			st = new StringTokenizer(s);
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if(a == 0 && b == 0)
				break;
			
			bw.write((a+b) + "\n");
		}
		bw.flush();
		bw.close();
	}

}
