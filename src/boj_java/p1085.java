package boj_java;
import java.util.Scanner;
public class p1085 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int ans = (w-x > h-y ? h-y : w-x);
		if(ans > x) ans = x;
		if(ans > y) ans = y;
		
		System.out.println(ans);
	}
}
