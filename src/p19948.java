import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p19948 {
	public static int N;
	public static int arr[] = new int[26];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(br.readLine());
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<26; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder title = new StringBuilder("");
		
		if(arr[getIdx(sb.charAt(0))] > 0) {
			arr[getIdx(sb.charAt(0))]--;
			
			if(sb.charAt(0) >= 'a' && sb.charAt(0) <= 'z') {
				title.append(sb.charAt(0) - 'a' + 'A');
			}else {
				title.append(sb.charAt(0));
			}
		}else {
			System.out.println("-1");
			return ;
		}
		
		for(int i=1; i<sb.length(); i++) {
			if(sb.charAt(i) != sb.charAt(i-1)) {
				if(sb.charAt(i-1) == ' ') {
					if(sb.charAt(i) >= 'a' && sb.charAt(i) <= 'z') {
						title.append(sb.charAt(i) - 'a' + 'A');
					}else {
						title.append(sb.charAt(i));
					}
				}
				
				if(sb.charAt(i) == ' ') {
					N--;
					if(N < 0) {
						System.out.println("-1");
						return ;
					}
				}else {
					arr[getIdx(sb.charAt(i))]--;
					if(arr[getIdx(sb.charAt(i))] < 0) {
						System.out.println("-1");
						return ;
					}
				}
			}
		}
		
		System.out.println(title.toString());
	}
	
	public static int getIdx(char c) {
		if(c >= 'A' && c<='Z') return c-'A';
		if(c >= 'a' && c<='z') return c-'a';
		return -1;
	}
}
