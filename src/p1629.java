import java.util.Scanner;

public class p1629 {
	public static long a, b, c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextLong();
		b = sc.nextLong();
		c = sc.nextLong();
		
		System.out.println(getS(a, b));
	}
	public static long getS(long n1, long n2) {
		long num = 1;
		if(n2 == 1) {
			return n1%c;
		}else {
			num = (getS(n1, n2/2))%c;
			if(n2 % 2 == 1) {
				return (((num * num)%c)*n1)%c;
			}else {
				return (num * num)%c;
			}
		}
	}
}
