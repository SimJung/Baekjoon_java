
import java.util.Scanner;
import java.util.Stack;
public class p1918 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> st = new Stack<>();
		StringBuilder sb = new StringBuilder(sc.next());
		StringBuilder answer = new StringBuilder();
		
		for(int i=0; i<sb.length(); i++) {
			if(sb.charAt(i) == '*' || sb.charAt(i) == '/')
			{
				for(int j=i-1; j>=0; j--) {
					if(sb.charAt(j) == '+' || sb.charAt(j) == '-' || j==0) {
						if(j == 0) {
							sb.insert(j, '(');
							break;
						}else {
							sb.insert(j+1, '(');
							break;
						}
					}
				}
				
				for(int j=i+1; j<sb.length(); j++) {
					if(sb.charAt(j) == '+' || sb.charAt(j) == '-' || j==sb.length()-1) {
						if(j == sb.length()-1) {
							sb.insert(j+1, ')');
							break;
						}else {
							sb.insert(j, ')');
							break;
						}
					}
				}
				i++;
			}
		}
		
		for(int i=0; i<sb.length(); i++) {
			if(isOp(sb.charAt(i))){
				st.push(sb.charAt(i));
			}else if(isBr(sb.charAt(i))){
				if(sb.charAt(i) ==')' && !st.empty()) {
					answer.append(st.pop());
				}
			}else {
				answer.append(sb.charAt(i));
			}
		}
		
		while(!st.empty())
			answer.append(st.pop());
		
		System.out.println(answer.toString());
	}
	
	public static boolean isOp(char c) {
		switch(c) {
		case '+':
		case '/':
		case '*':
		case '-':
			return true;
		}
		return false;
	}
	
	public static boolean isBr(char c) {
		switch(c) {
		case '(':
		case ')':
			return true;
		}
		return false;
	}
}
