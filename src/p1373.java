import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1373 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		
		int idx = 0, temp = 0;
		for(int i=str.length()-1; i>=0; i--) {
			temp |= ((str.charAt(i)-'0') << idx);
			if(++idx == 3 || i == 0) {
				idx = 0;
				sb.insert(0, temp);
				temp = 0;
			}
		}

		boolean isZero = true;
		for(int i=0; i<sb.length(); i++) {
			if(sb.charAt(i) != '0') isZero = false;
			
			if(!isZero) bw.write(sb.charAt(i));
		}
		if(isZero) bw.write("0");
		bw.write("\n");
		bw.flush();
		bw.close();
	}

}
