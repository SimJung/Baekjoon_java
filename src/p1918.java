
import java.util.Scanner;
import java.util.Stack;
public class p1918 {
	
	public static String origin;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		origin = sc.next();

		sb.append(makeStr(0));
	}
	
	public static String makeStr(int start) {
		StringBuilder temp = new StringBuilder();
		
		temp.append("(");
		
		temp.append(makeStr(start));
		
		temp.append(")");
		
		return temp.toString();
	}
}
