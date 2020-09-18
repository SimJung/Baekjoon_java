import java.util.ArrayList;
import java.util.Scanner;

public class p2605 {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(N);
		for(int i=0; i<N; i++) {
			arr.add(arr.size()-sc.nextInt(), i+1);
		}
		for(int i=0; i<N; i++) {
			System.out.print(arr.get(i)+" ");
		}
		System.out.println();
	}
}
