
import java.util.Scanner;
import java.util.Stack;
public class p1918 {
	
	public static StringBuilder origin, result = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		origin = new StringBuilder(sc.next());
		
		for(int i=0; i<origin.length(); i++) {
			if(origin.charAt(i) == '*' || origin.charAt(i) == '/') {
				if(origin.charAt(i-1) == ')') {
					int bn = 1, idx = i;
					for(int j=i-2; j>=0; j--) {
						if(origin.charAt(j) == '(')
							bn--;
						else if(origin.charAt(j) == ')')
							bn++;
						
						if(bn == 0) {
							idx = j;
							break;
						}
					}
					
					origin.insert(idx, '(');
				}else {
					origin.insert(i-1, '(');
				}
				
				i++;
				
				
				
				if(origin.charAt(i+1) == '(') {
					int bn = 1, idx = i;
					for(int j=i+2; j<origin.length(); j++) {
						if(origin.charAt(j) == ')')
							bn--;
						else if(origin.charAt(j) == '(')
							bn++;
						
						if(bn == 0) {
							idx = j;
							break;
						}
					}
					
					origin.insert(idx, ')');
				}else {
					origin.insert(i+2, ')');
				}
				
			}
		}
		
		System.out.println(origin.toString());

		Stack<Character> st = new Stack<>();
		boolean isOk = false;
		for(int i=0; i<origin.length(); i++) {
			switch(origin.charAt(i)) {
			case '+':
			case '*':
			case '-':
			case '/':
				st.push(origin.charAt(i));
				if(origin.charAt(i+1) != '(') isOk = true;
				break;
				
			case '(':
				break;
				
			case ')':
				if(!st.isEmpty()) {
					result.append(st.pop());
					isOk = false;
				}
				break;
				
			default:
				result.append(origin.charAt(i));
				if(isOk) {
					if(!st.isEmpty()) {
						result.append(st.pop());
						isOk = false;
					}
				}
				break;
				
			}
		}
		
		System.out.println(result.toString());
	}
	
}
