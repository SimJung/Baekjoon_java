import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
public class p4949 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> st = new Stack<>();
		StringBuilder sb;
		
		while(true) {
			st.clear();
			sb = new StringBuilder(bf.readLine());
			if(sb.toString().equals("."))
				return ;
			
			boolean chk = true;
			for(int i=0; i<sb.length(); i++) {
				if(sb.charAt(i) == '(' || sb.charAt(i) == '[')
					st.add(sb.charAt(i));
				else if(sb.charAt(i) == ')') {
					if(st.isEmpty() || st.pop() != '(')
					{
						chk = false;
						break;
					}
				}else if(sb.charAt(i) == ']') {
					if(st.isEmpty() || st.pop() != '[')
					{
						chk = false;
						break;
					}
				}
			}
			
			if(!chk || !st.isEmpty())
				System.out.println("no");
			else
				System.out.println("yes");
		}
	}

}
