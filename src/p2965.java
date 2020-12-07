import java.util.Scanner;

public class p2965 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A, B, C;
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
	
		System.out.println((B-A > C-B ? B-A-1 : C-B-1));
	}

}
