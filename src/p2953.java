import java.util.Scanner;

public class p2953 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int idx = 0, ans = 0;
		for(int i=1; i<=5; i++) {
			int sum = 0;
			for(int j=1; j<=4; j++) {
				sum += sc.nextInt();
			}
			
			if(sum > ans) {
				ans = sum;
				idx = i;
			}
		}
		
		System.out.println(idx + " " + ans);
	}

}
