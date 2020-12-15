
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
		
		//System.out.println(origin.toString());

		Stack<Character> st[] = new Stack[101];
		for(int i=0; i<=100; i++) {
			st[i] = new Stack<>();
		}
		int nowBn = 0;
		for(int i=0; i<origin.length(); i++) {
			switch(origin.charAt(i)) {
			case '+':
			case '*':
			case '-':
			case '/':
				st[nowBn].push(origin.charAt(i));
				break;
				
			case '(':
				nowBn++;
				break;
				
			case ')':
				nowBn--;
				if(!st[nowBn].isEmpty()) {
					result.append(st[nowBn].pop());
				}
				
				break;
				
			default:
				result.append(origin.charAt(i));
				if(!st[nowBn].isEmpty()) {
					result.append(st[nowBn].pop());
				}
				break;
				
			}
		}
		
		System.out.println(result.toString());
	}
	
}
