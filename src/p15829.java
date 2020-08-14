import java.util.Scanner;
public class p15829 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		long sum = 0;
		for(int i=0;i<s.length(); i++) {
			long mul = 1;
			for(int j=0; j<i; j++) {
				mul *= 31;
				mul %= 1234567891;
			}
			sum += (s.charAt(i)-'a'+1)*mul;
			sum %= 1234567891;
		}
		System.out.println(sum);
	}

}
