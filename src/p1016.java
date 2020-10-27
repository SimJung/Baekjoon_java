import java.util.Scanner;

public class p1016 {
	public static boolean arr[];
	public static long min, max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		min = sc.nextLong();
		max = sc.nextLong();
		
		int diff = (int)(max - min);
		arr = new boolean[diff+1];
		
		for(long i = 2; i*i<max; i++) {
			long add = i*i;
			if()
			for(long j=0; j<=max-min; j+=add) {
				
			}
		}
	}

}
