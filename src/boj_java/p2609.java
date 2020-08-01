package boj_java;
import java.util.Scanner;
public class p2609 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt();
		for(int i=(a>b ? b : a); i>0; i--) {
			if(a % i == 0 && b % i == 0) {
				System.out.println(i);
				break;
			}
		}
		
		for(int i=(a>b ? a : b); i<=a*b; i++) {
			if(i % a == 0 && i % b == 0) {
				System.out.println(i);
				return;
			}
		}
	}

}
