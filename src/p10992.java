import java.util.Scanner;

public class p10992 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			
			if(i == 1) {
				for(int j=n; j>1; j--) {
					System.out.print(' ');
				}
				System.out.println('*');
			}else if(i == n) {
				for(int j=0; j<(n*2)-1; j++) {
					System.out.print('*');
				}
				System.out.println();
			}else {
				for(int j=0; j<n-i; j++) {
					System.out.print(' ');
				}
				System.out.print('*');
				
				for(int j=0; j<(i-1)*2-1; j++) {
					System.out.print(' ');
				}
				System.out.println('*');
			}
			
		}
	}

}
