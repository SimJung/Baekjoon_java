import java.util.Scanner;

public class p10990 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			if(i == 0) {
				for(int j=i; j<N-1; j++) {
					System.out.print(" ");
				}
				System.out.println("*");
			}else {
				for(int j=i; j<N-1; j++) {
					System.out.print(" ");
				}
				System.out.print("*");
				for(int j=1; j<2*i; j++) {
					System.out.print(" ");
				}
				System.out.println("*");
			}
		}
	}

}
