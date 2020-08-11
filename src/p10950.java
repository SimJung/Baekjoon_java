
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
public class p10950 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T, a, b;
		T = Integer.parseInt(bf.readLine());
		String s;
		StringTokenizer st;
		
		for(int tc = 0; tc<T; tc++) {
			s = bf.readLine();
			st = new StringTokenizer(s);
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			bw.write((a+b)+"\n");
		}
		bw.flush();
		bw.close();
	}
}
