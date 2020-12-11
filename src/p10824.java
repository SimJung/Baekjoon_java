import java.util.Scanner;

public class p10824 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		String c = sc.next();
		String d = sc.next();
		
		String ab = a + b;
		String cd = c + d;
		
		System.out.println(Long.parseLong(ab) + Long.parseLong(cd));
	}

}
