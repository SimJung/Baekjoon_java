import java.util.Scanner;

public class p10156 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int snack, count, money, mommy;
		snack = sc.nextInt();
		count = sc.nextInt();
		money = sc.nextInt();
		
		mommy = (snack * count) - money;
		
		if(mommy < 0) mommy = 0;
		
		System.out.println(mommy);
	}
}
