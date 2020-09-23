import java.util.Scanner;

public class p3052 {
	public static boolean[] arr = new boolean[42];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for(int i=0; i<10; i++) {
			int temp =sc.nextInt();
			if(!arr[temp%42]) {
				sum++;
				arr[temp%42] = true;
			}
		}
		System.out.println(sum);
	}

}
