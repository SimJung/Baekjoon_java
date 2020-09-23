import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17413 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(br.readLine());
		StringBuilder ans = new StringBuilder("");
		
		boolean isTag = false;
		int startIdx = 0;
		for(int i=0; i<sb.length(); i++) {
			if(sb.charAt(i) == '<') {
				isTag = true;
				ans.append("<");
			}
			else if(sb.charAt(i) == '>') {
				isTag = false;
				ans.append(">");
			}
			else {
				startIdx = i;
				int endIdx = 0;
				boolean isSpace = false;
				if(!isTag) {
					if(sb.charAt(i) == ' ') continue;
					for(int j=startIdx; j<sb.length(); j++) {
						endIdx = j;
						if(sb.charAt(j) == ' ' || sb.charAt(j) == '<') {
							endIdx--;
							if(sb.charAt(j) == ' ') isSpace = true;
							break;
						}
					}
					
					for(int j=endIdx; j>=startIdx; j--) {
						ans.append(sb.charAt(j));
					}
					if(isSpace) ans.append(" ");
					i = endIdx;
				}else {
					ans.append(sb.charAt(i));
				}
			}
		}
		System.out.println(ans.toString());
	}

}
