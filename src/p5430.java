import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class p5430 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			StringBuilder fun = new StringBuilder(br.readLine());
			int N = Integer.parseInt(br.readLine());
			StringBuilder numStr = new StringBuilder(br.readLine());
			numStr.delete(0, 1);
			numStr.delete(numStr.length()-1, numStr.length());
			
			String strs[] = numStr.toString().split(",");
			
			int front = 0;
			int end = N-1;
			boolean isFront = true;
			boolean isError = false;
			
			for(int f=0; f<fun.length(); f++) {
				if(fun.charAt(f) == 'R') {
					isFront = !isFront;
				}else {
					if(isFront) {
						front++;
					}else {
						end--;
					}
					N--;
					if(N < 0) {
						isError = true;
						break;
					}
				}
			}
			
			if(isError) {
				System.out.println("error");
			}else {
				System.out.print("[");
				if(front <= end) {
					if(isFront) {
						for(int i=front; i<end; i++) {
							System.out.print(strs[i]+",");
						}
						System.out.print(strs[end]);
					}else {
						for(int i=end; i>front; i--) {
							System.out.print(strs[i]+",");
						}
						System.out.print(strs[front]);
					}
				}
				System.out.println("]");
			}
		}
	}

}
