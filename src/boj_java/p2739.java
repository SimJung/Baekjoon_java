package boj_java;
import java.util.Scanner;
public class p2739 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		
		for(int i=1; i<=9; i++) {
			System.out.println(n + " * " + i + " = " + n*i);
		}
	}

}
