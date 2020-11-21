import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p6588 {
	public static boolean isNotPrime[] = new boolean[1000001];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		for(int i=3; i<=1000000; i+=2) {
			if(!isNotPrime[i])
			{
				int mul = 2;
				while(true) {
					if(i*mul > 1000000) break;
					isNotPrime[i*mul++] = true;
				}
			}
		}
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			
			if(N == 0) break;
			
			boolean chk = true;
			int temp = 0;
			for(int i=3; i<1000001; i+=2) {
				if(N-i < 3) {
					chk = false;
					break;
				}
				else if(!isNotPrime[i] && !isNotPrime[N - i]) {
					temp = i;
					break;
				}
			}
			
			if(chk) {
				bw.write(N+" = " + temp + " + "+(N-temp)+"\n");
			}else {
				bw.write("Goldbach's conjecture is wrong.\n");
			}
		}
		
		bw.flush();
		bw.close();
	}

}
