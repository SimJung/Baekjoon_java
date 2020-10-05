import java.util.Scanner;

import java.util.Scanner;

public class p19945 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for(int i=31; i>=0; i--) {
			if((n&(1<<i)) != 0)
			{
				System.out.println(i+1);
				return ;
			}
		}
		System.out.println("1");
	}

}
