
import java.util.Scanner;
public class p1259 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n;
		while(!(n = sc.next()).equals("0")) {
			boolean ans = true;
			for(int i=0; i<n.length()/2; i++) {
				if(n.charAt(i) != n.charAt(n.length()-1-i)) {
					ans = false;
					break;
				}
			}
			
			System.out.println((ans ? "yes" : "no"));
		}
	}

}
