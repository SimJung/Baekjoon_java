
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
public class p10250 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(bf.readLine());
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int H = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
			
			int floor = ((N-1)%H) + 1;
			int cnt = ((N-1)/H) + 1;
			
			bw.write(floor+(cnt<10 ? "0":"")+cnt+"\n");
		}
		bw.flush();
		bw.close();
	}

}
